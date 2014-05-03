<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	try {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="default.css" rel="stylesheet" type="text/css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票结果</title>
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<center>
		<%
			Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/vote", "root", "123456");
				request.setCharacterEncoding("utf-8");
				String ni = request.getParameter("checkbox");
				String name = request.getParameter("name");
				String time = request.getParameter("checkboxForTime");
				if (ni != null && time != null) {
					String ip = request.getRemoteAddr();
					String ips[] = ip.split("\\.");

					int vi = Integer.parseInt(ni);
					PreparedStatement ps = c
							.prepareStatement("SELECT * FROM record where ip = ?");
					ps.setString(1, ip);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						out.println("<span style='color:red'>IP: " + ip
								+ " 已经参与过投票！</span>");
					} else {
						ps = c.prepareStatement("INSERT into record(ip,fid,name,time) VALUES (?,?,?,?)");
						ps.setString(1, ip);
						ps.setInt(2, vi);
						ps.setString(3, name);
						ps.setTimestamp(4, Timestamp.valueOf(time));
						ps.execute();
						out.println("IP：" + request.getRemoteAddr() + name
								+ "		选择方案" + ni);
					}
				}
		%><br />
		<h2>投票结果</h2>
		<%
			String[] places = new String[4];
				places[0] = "延庆龙庆峡一日游";
				places[1] = "京东大峡谷一日游";
				places[2] = "桃源仙谷一日游";
				places[3] = "潭柘寺戒台寺一日游";
				String result = "<table>";
				for (int i = 1; i <= 4; i++) {
					PreparedStatement ps = c
							.prepareStatement("SELECT COUNT(*) from record where fid =? ");
					ps.setInt(1, i);
					ResultSet rs = ps.executeQuery();
					int i1 = 0;
					if (rs.next()) {
						i1 = rs.getInt(1);
					}
					String cstr = "" + i1;
					if (i1 < 10) {
						cstr = "&nbsp;" + cstr;
					}
					result += "<tr><td>" + "方案" + i + " " + places[i - 1] + "："
							+ "</td><td>" + cstr + "票<br /></td></tr>";
					//out.println("方案" + i + " " + places[i - 1] + "：" + cstr
					//	+ "票<br />");
				}
				result += "</table>";
				out.print(result);
		%>
		<h2>出游时间结果</h2>
		<%
			Timestamp[] timestamps = {
						Timestamp.valueOf("2014-05-10 00:00:00"),
						Timestamp.valueOf("2014-05-11 00:00:00"),
						Timestamp.valueOf("2014-05-17 00:00:00"),
						Timestamp.valueOf("2014-05-18 00:00:00"),
						Timestamp.valueOf("2014-06-07 00:00:00"),
						Timestamp.valueOf("2014-06-08 00:00:00") };
				String[] times = { "5月10日", "5月11日", "5月17日", "5月18日", "6月07日",
						"6月08日" };
				String resultForTime = "";
				for (int i = 0; i < 6; i++) {
					PreparedStatement ps = c
							.prepareStatement("SELECT COUNT(*) from record where time =? ");
					ps.setTimestamp(1, timestamps[i]);
					ResultSet rs = ps.executeQuery();
					int i1 = 0;
					if (rs.next()) {
						i1 = rs.getInt(1);
					}
					String cstr = "" + i1;
					if (i1 < 10) {
						cstr = "&nbsp;" + cstr;
					}
					resultForTime += "<p>出行时间 -> " + times[i] + "：" + cstr
							+ "票<br /></p>";
				}
				out.print(resultForTime);
		%>
		<br />
		<div id="info1" style="overflow: scroll; height: 300px;">
			<table>
				<%
					PreparedStatement ps = c
								.prepareStatement("SELECT * from record order by time desc");
						ResultSet rs = ps.executeQuery();
						DateFormat df = new SimpleDateFormat(" [MM-dd HH:mm:ss]");
						int i = 1;
						while (rs.next()) {
							String ip = rs.getString("ip");
							int fid = rs.getInt("fid");
							name = rs.getString("name");
							Timestamp ts = rs.getTimestamp("time");
							String t = df.format(ts);
							out.println("<tr><td>" + t + " IP：</td><td>"
									+ "<span style='color:gray'>" + ip
									+ "</span></td><td><span style='color:gray'>"
									+ name
									+ "</span></td><td>	选择 <span style='color:blue'>方案"
									+ fid + "</span><br /></td></tr>");
						}
				%>
			</table>
		</div>
	</center>
</body>
</html>
<%
	} catch (Exception e) {
		e.printStackTrace();
		out.println(e.getMessage());
		out.println("请先选择再提交");
		out.println("<a href=index.jsp>返回</a>");
	}
%>