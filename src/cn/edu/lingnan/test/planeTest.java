package cn.edu.lingnan.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dao.ClientDAO;
import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dao.TicketpurchaseDAO;
import cn.edu.lingnan.dto.ClientDTO;
import cn.edu.lingnan.dto.TicketDTO;
import cn.edu.lingnan.dto.TicketpurchaseDTO;

public class planeTest {

	public static void main(String[] args) throws IOException {
				
		InputStreamReader is = new InputStreamReader(System.in); //new构造InputStreamReader对象   
		BufferedReader br = new BufferedReader(is);
		
//		ClientDAO tdao = new ClientDAO();
//		String cid = br.readLine();
//		tdao.deleteClientById(cid);
		
		TicketpurchaseDAO tpdao = new TicketpurchaseDAO();
		System.out.println("请依次输入要删除的客户id和机票id：");		
		String cid = br.readLine();
		String tid = br.readLine();
		if(tpdao.deleteTicketpurchaseId(cid, tid))
			System.out.println("删除成功！");
		
		
		
		
//		
//		TicketDAO tdao = new TicketDAO();
//		Vector<TicketDTO> v2 = new Vector<TicketDTO>(); 
//		System.out.println("请输入要删除的机票id：");
//		String tid = br.readLine();
//		if(tdao.deleteTicketById(tid))
//			System.out.println("删除成功！");

		
//		v2 = tdao.findAllTicketInfo();
//		System.out.println("eeeeeeeeeee");
//		for(TicketDTO ct : v2){
//			    System.out.println("id:"+ct.getTid());
//		}
		
		
		//查----查找所有客户姓名
//		InputStreamReader is = new InputStreamReader(System.in); //new构造InputStreamReader对象   
//		BufferedReader br = new BufferedReader(is);
//		ClientDAO cdao = new ClientDAO();
//		Vector<ClientDTO> v = new Vector<ClientDTO>();
//		String password = null;
//		String cname = null;
//		System.out.println("请输入要查找的cid：");
//		cname = br.readLine();
//		password = br.readLine();
//		System.out.println(cdao.findClientBynameAndPassword(cname, password));	
	}
	
	
//	public static void main(String[] args) throws IOException {  
//		System.out.println("对于客户表：");	
//		System.out.println("       1.添加客户");
//		System.out.println("       2.根据id删除客户");
//		System.out.println("       3.查找所有客户");
//		System.out.println("       4.根据id查找客户");
//		System.out.println("       5.更新客户号码");
//		System.out.println("       6.退出对该表操作");
//		System.out.println("---------------------------------------");
//		System.out.println("对于机票定购表： ");
//		System.out.println("       1.根据客户id和机票id查找订购机票");
//		System.out.println("       2.购买机票 ");
//		System.out.println("       3.删除机票订单");
//		System.out.println("       4.退出对该表操作");
//		System.out.println("----------------------------------------");
//		System.out.println("对于机票信息表：");
//		System.out.println("       1.根据机票id查找机票信息 ");
//		System.out.println("       2.根据id删除机票信息");
//		System.out.println("       3.添加机票信息");
//		System.out.println("       4.根据机票id修改起飞时间");
//		System.out.println("       5.退出对该表操作");
//		System.out.println("----------------------------------------\n");
//		InputStreamReader is = new InputStreamReader(System.in); //new构造InputStreamReader对象   
//		BufferedReader br = new BufferedReader(is);   
//		String cid = null;
//		String tid = null;
//		String status0 = null;
//		int status;	//标记信息记录的状态，0表示存在，1表示已删除
//		String t0 = null;
//		int t;	
//		boolean fl = true;
//		while(fl){ //第一层循环，对操作三个表的循环
//			System.out.println("1.操作客户表");
//			System.out.println("2.操作机票订购表");
//			System.out.println("3.操作机票信息表 ");
//			System.out.println("4.退出");
//			System.out.print("请选择操作的表：  ");
//			String k0 = br.readLine();
//			int k = Integer.parseInt(k0);		
//			switch(k){			
//			case 1: //操作客户表
//				String cname = null;
//				String tel = null;
//				String password = null;
//				String superpassword = null;
//			    boolean fl0 = true;
//		        while (fl0){ //第二层循环，对表功能的循环
//		        	ClientDAO cdao = new ClientDAO();
//					Vector<ClientDTO> v = new Vector<ClientDTO>();
//					System.out.println("对于客户表：");	
//					System.out.println("       1.添加客户");
//					System.out.println("       2.根据id删除客户");
//					System.out.println("       3.查找所有客户");
//					System.out.println("       4.根据id查找客户");
//					System.out.println("       5.更新客户号码");
//					System.out.println("       6.退出对该表操作");				
//					System.out.print("请选择：  ");	
//					t0 = br.readLine();
//					t = Integer.parseInt(t0);
//					switch(t){          
//					    case 1: //增------添加客户信息
//					        System.out.println("请输入要插入的客户信息：");
//					        System.out.print("请输入客户cid：");cid = br.readLine();
//					        System.out.print("请输入名称：");cname = br.readLine();
//					        System.out.print("请输入密码：");password = br.readLine();
//					        System.out.print("请输入超级密码：");superpassword = br.readLine();
//					        System.out.print("请输入0：");status0 = br.readLine();
//							status = Integer.parseInt(status0);	
//					        if(cdao.insertIntoClient(cid, cname, tel, password, superpassword, status)){
//					        	System.out.println("客户信息插入成功！");
//					        }
//					        else
//					        	System.out.println("该客户信息已存在！");
//					        break;
//					    case 2://删----根据id删除客户信息
//					        System.out.print("请输入要删除客户信息的id:");
//					        cid = br.readLine();
//					        if(cdao.deleteClientById(cid)){
//					        	System.out.println("删除客户成功！");
//					        }
//					        break;		
//					    case 3://查----查找所有客户姓名
//
//					    	System.out.println("全部客户信息如下：");
//					        for(ClientDTO ct : v){
//						        int tmp = 0;
//						        if(tmp == ct.getStatus()){
//						            System.out.println("id:"+ct.getCid()+"  姓名："+ct.getCname()+"  电话："+ct.getTel());
//						        }
//						    }
//						    break;	
//					    case 4://查------根据id查客户信息
//							System.out.println("请输入要查找的cid：");
//							cid = br.readLine();
//							v = cdao.findClientInfoById(cid);		
//							for(ClientDTO ct : v){
//								int tmp = 0;
//								if(tmp == ct.getStatus()){
//								    System.out.println("id:"+ct.getCid()+"  姓名："+ct.getCname()+"  电话："+ct.getTel());
//								}
//							    else
//							    	System.out.println("该客户不存在");
//							}
//						    break;
//					    case 5:	//改----根据id修改客户电话
//					    	Scanner sc4 = new Scanner(System.in);
//							System.out.println("请输入客户id");
//					        cid = sc4.nextLine();
//					        System.out.println("请输入该客户要修改的tel");
//					        tel = sc4.nextLine();
//					        System.out.println(cdao.updateClientTelById(cid, tel));
//					        System.out.println("更新成功！");
//					        break;
//					    case 6:
//					        fl0 = false;
//					        System.out.println("已退出对客户表操作！");
//					        break;
//					}			
//		        }
//		        break;
//			
//			case 2: //操作机票订购表
//				boolean fl1 = true;
//				while(fl1){
//					TicketpurchaseDAO tpdao = new TicketpurchaseDAO();
//					Vector<TicketpurchaseDTO> vtp = new Vector<TicketpurchaseDTO>();
//					System.out.println("对于机票定购表： ");
//					System.out.println("       1.根据客户id和机票id查找订购机票");
//					System.out.println("       2.购买机票 ");
//					System.out.println("       3.删除机票订单");
//					System.out.println("       4.退出对该表操作");
//					System.out.print("请选择：  ");	
//					t0 = br.readLine();
//					t = Integer.parseInt(t0);
//					switch(t){
//						case 1://查-----根据id查找客户机票购买信息
//							System.out.println("请输入要查找的客户id和机票id：");
//							cid = br.readLine();
//							tid = br.readLine();
//							vtp = tpdao.findTicketpurchaseInfoById(cid, tid);		
//							for(TicketpurchaseDTO ct : vtp){
//								int tmp = 0;
//								if(tmp == ct.getStatus()){
//								    System.out.println("客户id:"+ct.getCid()+"  机票id："+ct.getTid()+"  座位类型："+ct.getSpaceType()+"  买票日期："+ct.getPurchaseDate());
//								}
//							    else
//							    	System.out.println("该客户还未有购买机票！");
//							}
//						    break;
//						case 2:	//增-------增加订单，购买机票
//                            String spaceType = null;
//                            String purchaseDate = null;	
//							System.out.println("请依次输入购买的信息：");
//							System.out.print("请输入客户cid：");cid = br.readLine();
//							System.out.print("请输入机票tid：");tid = br.readLine();
//							System.out.print("请输入座位类型：");spaceType = br.readLine();
//							System.out.print("请输入购买时间：");purchaseDate = br.readLine();
//							System.out.print("请输入0：");status0 = br.readLine();
//							status = Integer.parseInt(status0);							
//							if(tpdao.insertIntoTicketpurchase(cid, tid, spaceType, purchaseDate, status))
//							    System.out.println("购买成功！");
//							else
//								System.out.println("购买失败！该航班已满");
//					        break;
//						case 3:		//删----删除机票购买信息
//							System.out.println("请依次输入要删除的客户id和机票id：");
//							cid = br.readLine();
//							tid = br.readLine();
//							if(tpdao.deleteTicketpurchaseId(cid, tid))
//								System.out.println("删除成功！");
//							break;
//						case 4:   //退出对机票订购表的操作
//							fl1 = false;  
//							System.out.println("已退出对机票订购表操作！");
//							break;
//					}
//				}
//			    break;
//			case 3://操作机票航班表
//				boolean fl3 = true;
//				TicketDAO tdao = new TicketDAO();
//				Vector<TicketDTO> vtdto = new Vector<TicketDTO>();
//				while(fl3){
//					System.out.println("对于机票信息表：");
//					System.out.println("       1.根据机票id查找机票信息 ");
//					System.out.println("       2.根据id删除机票信息");
//					System.out.println("       3.添加机票信息");
//					System.out.println("       4.根据机票id修改起飞时间");
//					System.out.println("       5.退出对该表操作");
//					System.out.print("请选择：  ");
//					t0 = br.readLine();
//					t = Integer.parseInt(t0);
//					switch(t){
//						case 1: //查--------根据机票id查找机票航班信息
//							System.out.println("请输入要查找的机票id：");
//							tid = br.readLine();
//							vtdto = tdao.findTicketInfoById(tid);
//							for(TicketDTO ct : vtdto){
//								int tmp = 0;
//								if(tmp == ct.getStatus()){ //判断机票的状态标志，为0则表示该航班机票未删除，可以查询
//								    System.out.println("机票id："+ct.getTid()+"  航班号fightNumber："+ct.getFightNumber()+"  目的地destination："+ct.getDestination()
//								    		+"  起飞时间OffDate:"+ct.getOffDate()+"  价格price:"+ct.getPrice()+"  余量allowance:"+ct.getAllowance());
//								}
//							    else
//							    	System.out.println("该机票不存在！");
//							}
//							break;
//						case 2: //删----根据机票id删除机票航班信息				
//							System.out.println("请输入要删除的机票id：");
//							tid = br.readLine();
//							if(tdao.deleteTicketById(tid))
//								System.out.println("删除成功！");
//							break;
//						case 3:	//增----添加机票航班记录
//							String fightNumber = null;
//							String destination = null;
//							String offDate = null;
//							String price = null;
//							String allowance0 = null;
//							int allowance;
//							System.out.println("请输入要添加机票的信息：");
//							System.out.print("请输入机票tid：");tid = br.readLine();
//							System.out.print("请输入航班号：");fightNumber = br.readLine();
//							System.out.print("请输入目的地：");destination = br.readLine();
//							System.out.print("请输入起飞时间：");offDate = br.readLine();	
//							System.out.print("请输入价格：");price = br.readLine();
//							System.out.print("请输入余量：");
//							allowance0 = br.readLine();
//						    allowance = Integer.parseInt(allowance0);
//							System.out.print("请输入0：");status0 = br.readLine();
//							status = Integer.parseInt(status0);		
//							if(tdao.insertIntoTicket(tid, fightNumber, destination, offDate, price, allowance, status))
//							    System.out.println("机票记录插入成功！");
//							break;
//						case 4:	//改------根据id修改机票起飞时间
//							System.out.println("请输入机票id");
//					        tid = br.readLine();
//					        System.out.println("请输入修改的起飞时间");
//					        offDate = br.readLine();
//					        if(tdao.updateTicketById(offDate, tid))
//					            System.out.println("更新成功！");
//							break;
//						case 5:
//							fl3 = false;
//							System.out.println("已退出对机票航信息表操作！");
//							break;
//					}
//				}
//
//				break;
//			case 4: //退出
//				fl = false;
//				System.out.println("已退出！");
//				break;
//			}			
//		}
//						
//	}

}
