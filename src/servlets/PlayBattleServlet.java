package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import robocode.CompileRobocode;
import DTO.RobotDTO;
import DTO.UserDTO;
import Service.RobotClientRestService;
import edu.utdallas.Compile;

public class PlayBattleServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	Connection conn = null; 
	
	public PlayBattleServlet() {
		super(); 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, BufferedReader> errors_map = new HashMap<String, BufferedReader>();
		HttpSession session = req.getSession();
		String userName = (String) session.getAttribute("userx");
		boolean error_flag = false;
		if(userName!=null){
			String[] robotNames = req.getParameterValues("selectto");
			
			//****************************************************************
			//get the class file of robotNames from database
			if(robotNames.length != 0) {
				try {
					List<String> names = new ArrayList<String>(); 
					List<String> srcs = new ArrayList<String>(); 
					conn = DAO.ConnectionFactory.getInstance().getConnection(); 
					String sql = "SELECT file FROM robot WHERE robotID = ?"; 
					PreparedStatement pstmt = conn.prepareStatement(sql); 
					for(String name : robotNames) {
						pstmt.setString(1, name);
						ResultSet rs = pstmt.executeQuery(); 
						Blob robotFile = rs.getBlob("file"); 
						//transfer Blob to a string
						byte[] bytes = robotFile.getBytes(1, (int)robotFile.length()); 
						String src = new String(bytes); 
						names.add(name); 
						srcs.add(src); 
					}
					//use JavaCompiler to complie the JavaObjectFile into a jar file
					Compile.complieToJar(names, srcs, getServletContext().getRealPath("/"));
				}catch(SQLException e) {
					e.printStackTrace(System.err); 
				}finally {
					if(conn != null) {
						try {
							conn.close(); 
						}catch(SQLException e) {
							e.printStackTrace(System.err);
						}
					}
				}
			}
			//****************************************************************
			
			String numberofrounds = req.getParameter("rounds");
			System.out.println("+==========The number of rounds to play========" + numberofrounds);
			RobotClientRestService robotClientRestService = new RobotClientRestService();
			//System.out.println();
			/*
			 * robots_name must be in the format of : Package_name1.class_name1,package_name2.class_name2,etc... 
			 */
			/**
			String robots_name = "";
			boolean comma_flag = false;
			for(int i=0;i<robotNames.length;i++)
			{
				RobotDTO robotDTO = robotClientRestService.getRobotForBattle(robotNames[i].toString());
				System.out.println(robotDTO.getRobotDescription()+" "+robotDTO.getPackageId());
				String domainPath = getServletContext().getRealPath("/");
				domainPath = domainPath + "jar";
				BufferedReader compileFlag = CompileRobocode.compileRobocode(robotDTO,domainPath);
				
				//Create string which is the input for the applet
					
				if(compileFlag.readLine() == null && !comma_flag)
				{
					robots_name = robotDTO.getPackageId() + "." + robotDTO.getRobotName() + robots_name;
					comma_flag = true;
				}
				else if(compileFlag.readLine() == null && comma_flag)
				{
					robots_name = robots_name + "," + robotDTO.getPackageId() + "." + robotDTO.getRobotName();
				}
				else{
					error_flag = true;
					errors_map.put(robotDTO.getRobotName(), compileFlag);
				}
				
			}
			System.out.println("the robots name are  " + robots_name);
			//Now send the robots_name to the applet's JSP page called : robocode.html
			//session.setAttribute("robots_name", "sample.Fire,sample.Corners");
			if(!error_flag){
				session.setAttribute("robots_name", robots_name);
				session.setAttribute("numberofrounds", numberofrounds);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("robocode.jsp");
				requestDispatcher.forward(req, resp);				
			}
			else{
				session.setAttribute("errors_map", errors_map);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("robocode_error.jsp");
				requestDispatcher.forward(req, resp);
			}	
			*/	
		}		
	}

	
	
}
