package webchat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import util.DBUtil;

@ServerEndpoint("/mychat")
public class MyWebSocket {
  // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
  private static int onlineCount = 0;

  private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

  // 与某个客户端的连接会话，需要通过它来给客户端发送数据
  private Session session;
  @OnOpen
  public void onOpen(Session session) {
    this.session = session;
    webSocketSet.add(this);
    addOnlineCount();
    System.out.println("有人加入！当前在线人数为" + getOnlineCount());
  }

  @OnClose
  public void onClose() {
    webSocketSet.remove(this); // 从set中删除
    subOnlineCount(); // 在线数减1
    System.out.println("有人退出！当前在线人数为" + getOnlineCount());
  }

  @OnMessage
  public void onMessage(String message, Session session) {
      String[] sourceStrArray = message.split(":", 3);//分割字符串成三段
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String time = sdf.format(new Date());
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      try {
          conn = DBUtil.getConnection();
          String sql = "INSERT INTO chatlog(user_id, content, pub_time) VALUES(?, ?, ?)";
          stmt = conn.prepareStatement(sql);
          stmt.setString(1, sourceStrArray[0]);
          stmt.setString(2, sourceStrArray[2]);
          stmt.setString(3, time);
          stmt.execute();
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          DBUtil.close(rs, stmt, conn);
      }
    for (MyWebSocket item : webSocketSet) {
      try {
        item.sendMessage(sourceStrArray[1]+"|"+sourceStrArray[2]+"|"+time);
      } catch (IOException e) {
        e.printStackTrace();
        continue;
      }
    }
  }
  @OnError
  public void onError(Session session, Throwable error) {
    System.out.println("服务器内部发生错误");
    error.printStackTrace();
  }
  public void sendMessage(String message) throws IOException {
    this.session.getBasicRemote().sendText(message);
  }
  public static synchronized int getOnlineCount() {
    return onlineCount;
  }
  public static synchronized void addOnlineCount() {
    MyWebSocket.onlineCount++;
  }
  public static synchronized void subOnlineCount() {
    MyWebSocket.onlineCount--;
  }
}
