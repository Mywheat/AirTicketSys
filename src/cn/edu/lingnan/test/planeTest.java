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
				
		InputStreamReader is = new InputStreamReader(System.in); //new����InputStreamReader����   
		BufferedReader br = new BufferedReader(is);
		
//		ClientDAO tdao = new ClientDAO();
//		String cid = br.readLine();
//		tdao.deleteClientById(cid);
		
		TicketpurchaseDAO tpdao = new TicketpurchaseDAO();
		System.out.println("����������Ҫɾ���Ŀͻ�id�ͻ�Ʊid��");		
		String cid = br.readLine();
		String tid = br.readLine();
		if(tpdao.deleteTicketpurchaseId(cid, tid))
			System.out.println("ɾ���ɹ���");
		
		
		
		
//		
//		TicketDAO tdao = new TicketDAO();
//		Vector<TicketDTO> v2 = new Vector<TicketDTO>(); 
//		System.out.println("������Ҫɾ���Ļ�Ʊid��");
//		String tid = br.readLine();
//		if(tdao.deleteTicketById(tid))
//			System.out.println("ɾ���ɹ���");

		
//		v2 = tdao.findAllTicketInfo();
//		System.out.println("eeeeeeeeeee");
//		for(TicketDTO ct : v2){
//			    System.out.println("id:"+ct.getTid());
//		}
		
		
		//��----�������пͻ�����
//		InputStreamReader is = new InputStreamReader(System.in); //new����InputStreamReader����   
//		BufferedReader br = new BufferedReader(is);
//		ClientDAO cdao = new ClientDAO();
//		Vector<ClientDTO> v = new Vector<ClientDTO>();
//		String password = null;
//		String cname = null;
//		System.out.println("������Ҫ���ҵ�cid��");
//		cname = br.readLine();
//		password = br.readLine();
//		System.out.println(cdao.findClientBynameAndPassword(cname, password));	
	}
	
	
//	public static void main(String[] args) throws IOException {  
//		System.out.println("���ڿͻ���");	
//		System.out.println("       1.��ӿͻ�");
//		System.out.println("       2.����idɾ���ͻ�");
//		System.out.println("       3.�������пͻ�");
//		System.out.println("       4.����id���ҿͻ�");
//		System.out.println("       5.���¿ͻ�����");
//		System.out.println("       6.�˳��Ըñ����");
//		System.out.println("---------------------------------------");
//		System.out.println("���ڻ�Ʊ������ ");
//		System.out.println("       1.���ݿͻ�id�ͻ�Ʊid���Ҷ�����Ʊ");
//		System.out.println("       2.�����Ʊ ");
//		System.out.println("       3.ɾ����Ʊ����");
//		System.out.println("       4.�˳��Ըñ����");
//		System.out.println("----------------------------------------");
//		System.out.println("���ڻ�Ʊ��Ϣ��");
//		System.out.println("       1.���ݻ�Ʊid���һ�Ʊ��Ϣ ");
//		System.out.println("       2.����idɾ����Ʊ��Ϣ");
//		System.out.println("       3.��ӻ�Ʊ��Ϣ");
//		System.out.println("       4.���ݻ�Ʊid�޸����ʱ��");
//		System.out.println("       5.�˳��Ըñ����");
//		System.out.println("----------------------------------------\n");
//		InputStreamReader is = new InputStreamReader(System.in); //new����InputStreamReader����   
//		BufferedReader br = new BufferedReader(is);   
//		String cid = null;
//		String tid = null;
//		String status0 = null;
//		int status;	//�����Ϣ��¼��״̬��0��ʾ���ڣ�1��ʾ��ɾ��
//		String t0 = null;
//		int t;	
//		boolean fl = true;
//		while(fl){ //��һ��ѭ�����Բ����������ѭ��
//			System.out.println("1.�����ͻ���");
//			System.out.println("2.������Ʊ������");
//			System.out.println("3.������Ʊ��Ϣ�� ");
//			System.out.println("4.�˳�");
//			System.out.print("��ѡ������ı�  ");
//			String k0 = br.readLine();
//			int k = Integer.parseInt(k0);		
//			switch(k){			
//			case 1: //�����ͻ���
//				String cname = null;
//				String tel = null;
//				String password = null;
//				String superpassword = null;
//			    boolean fl0 = true;
//		        while (fl0){ //�ڶ���ѭ�����Ա��ܵ�ѭ��
//		        	ClientDAO cdao = new ClientDAO();
//					Vector<ClientDTO> v = new Vector<ClientDTO>();
//					System.out.println("���ڿͻ���");	
//					System.out.println("       1.��ӿͻ�");
//					System.out.println("       2.����idɾ���ͻ�");
//					System.out.println("       3.�������пͻ�");
//					System.out.println("       4.����id���ҿͻ�");
//					System.out.println("       5.���¿ͻ�����");
//					System.out.println("       6.�˳��Ըñ����");				
//					System.out.print("��ѡ��  ");	
//					t0 = br.readLine();
//					t = Integer.parseInt(t0);
//					switch(t){          
//					    case 1: //��------��ӿͻ���Ϣ
//					        System.out.println("������Ҫ����Ŀͻ���Ϣ��");
//					        System.out.print("������ͻ�cid��");cid = br.readLine();
//					        System.out.print("���������ƣ�");cname = br.readLine();
//					        System.out.print("���������룺");password = br.readLine();
//					        System.out.print("�����볬�����룺");superpassword = br.readLine();
//					        System.out.print("������0��");status0 = br.readLine();
//							status = Integer.parseInt(status0);	
//					        if(cdao.insertIntoClient(cid, cname, tel, password, superpassword, status)){
//					        	System.out.println("�ͻ���Ϣ����ɹ���");
//					        }
//					        else
//					        	System.out.println("�ÿͻ���Ϣ�Ѵ��ڣ�");
//					        break;
//					    case 2://ɾ----����idɾ���ͻ���Ϣ
//					        System.out.print("������Ҫɾ���ͻ���Ϣ��id:");
//					        cid = br.readLine();
//					        if(cdao.deleteClientById(cid)){
//					        	System.out.println("ɾ���ͻ��ɹ���");
//					        }
//					        break;		
//					    case 3://��----�������пͻ�����
//
//					    	System.out.println("ȫ���ͻ���Ϣ���£�");
//					        for(ClientDTO ct : v){
//						        int tmp = 0;
//						        if(tmp == ct.getStatus()){
//						            System.out.println("id:"+ct.getCid()+"  ������"+ct.getCname()+"  �绰��"+ct.getTel());
//						        }
//						    }
//						    break;	
//					    case 4://��------����id��ͻ���Ϣ
//							System.out.println("������Ҫ���ҵ�cid��");
//							cid = br.readLine();
//							v = cdao.findClientInfoById(cid);		
//							for(ClientDTO ct : v){
//								int tmp = 0;
//								if(tmp == ct.getStatus()){
//								    System.out.println("id:"+ct.getCid()+"  ������"+ct.getCname()+"  �绰��"+ct.getTel());
//								}
//							    else
//							    	System.out.println("�ÿͻ�������");
//							}
//						    break;
//					    case 5:	//��----����id�޸Ŀͻ��绰
//					    	Scanner sc4 = new Scanner(System.in);
//							System.out.println("������ͻ�id");
//					        cid = sc4.nextLine();
//					        System.out.println("������ÿͻ�Ҫ�޸ĵ�tel");
//					        tel = sc4.nextLine();
//					        System.out.println(cdao.updateClientTelById(cid, tel));
//					        System.out.println("���³ɹ���");
//					        break;
//					    case 6:
//					        fl0 = false;
//					        System.out.println("���˳��Կͻ��������");
//					        break;
//					}			
//		        }
//		        break;
//			
//			case 2: //������Ʊ������
//				boolean fl1 = true;
//				while(fl1){
//					TicketpurchaseDAO tpdao = new TicketpurchaseDAO();
//					Vector<TicketpurchaseDTO> vtp = new Vector<TicketpurchaseDTO>();
//					System.out.println("���ڻ�Ʊ������ ");
//					System.out.println("       1.���ݿͻ�id�ͻ�Ʊid���Ҷ�����Ʊ");
//					System.out.println("       2.�����Ʊ ");
//					System.out.println("       3.ɾ����Ʊ����");
//					System.out.println("       4.�˳��Ըñ����");
//					System.out.print("��ѡ��  ");	
//					t0 = br.readLine();
//					t = Integer.parseInt(t0);
//					switch(t){
//						case 1://��-----����id���ҿͻ���Ʊ������Ϣ
//							System.out.println("������Ҫ���ҵĿͻ�id�ͻ�Ʊid��");
//							cid = br.readLine();
//							tid = br.readLine();
//							vtp = tpdao.findTicketpurchaseInfoById(cid, tid);		
//							for(TicketpurchaseDTO ct : vtp){
//								int tmp = 0;
//								if(tmp == ct.getStatus()){
//								    System.out.println("�ͻ�id:"+ct.getCid()+"  ��Ʊid��"+ct.getTid()+"  ��λ���ͣ�"+ct.getSpaceType()+"  ��Ʊ���ڣ�"+ct.getPurchaseDate());
//								}
//							    else
//							    	System.out.println("�ÿͻ���δ�й����Ʊ��");
//							}
//						    break;
//						case 2:	//��-------���Ӷ����������Ʊ
//                            String spaceType = null;
//                            String purchaseDate = null;	
//							System.out.println("���������빺�����Ϣ��");
//							System.out.print("������ͻ�cid��");cid = br.readLine();
//							System.out.print("�������Ʊtid��");tid = br.readLine();
//							System.out.print("��������λ���ͣ�");spaceType = br.readLine();
//							System.out.print("�����빺��ʱ�䣺");purchaseDate = br.readLine();
//							System.out.print("������0��");status0 = br.readLine();
//							status = Integer.parseInt(status0);							
//							if(tpdao.insertIntoTicketpurchase(cid, tid, spaceType, purchaseDate, status))
//							    System.out.println("����ɹ���");
//							else
//								System.out.println("����ʧ�ܣ��ú�������");
//					        break;
//						case 3:		//ɾ----ɾ����Ʊ������Ϣ
//							System.out.println("����������Ҫɾ���Ŀͻ�id�ͻ�Ʊid��");
//							cid = br.readLine();
//							tid = br.readLine();
//							if(tpdao.deleteTicketpurchaseId(cid, tid))
//								System.out.println("ɾ���ɹ���");
//							break;
//						case 4:   //�˳��Ի�Ʊ������Ĳ���
//							fl1 = false;  
//							System.out.println("���˳��Ի�Ʊ�����������");
//							break;
//					}
//				}
//			    break;
//			case 3://������Ʊ�����
//				boolean fl3 = true;
//				TicketDAO tdao = new TicketDAO();
//				Vector<TicketDTO> vtdto = new Vector<TicketDTO>();
//				while(fl3){
//					System.out.println("���ڻ�Ʊ��Ϣ��");
//					System.out.println("       1.���ݻ�Ʊid���һ�Ʊ��Ϣ ");
//					System.out.println("       2.����idɾ����Ʊ��Ϣ");
//					System.out.println("       3.��ӻ�Ʊ��Ϣ");
//					System.out.println("       4.���ݻ�Ʊid�޸����ʱ��");
//					System.out.println("       5.�˳��Ըñ����");
//					System.out.print("��ѡ��  ");
//					t0 = br.readLine();
//					t = Integer.parseInt(t0);
//					switch(t){
//						case 1: //��--------���ݻ�Ʊid���һ�Ʊ������Ϣ
//							System.out.println("������Ҫ���ҵĻ�Ʊid��");
//							tid = br.readLine();
//							vtdto = tdao.findTicketInfoById(tid);
//							for(TicketDTO ct : vtdto){
//								int tmp = 0;
//								if(tmp == ct.getStatus()){ //�жϻ�Ʊ��״̬��־��Ϊ0���ʾ�ú����Ʊδɾ�������Բ�ѯ
//								    System.out.println("��Ʊid��"+ct.getTid()+"  �����fightNumber��"+ct.getFightNumber()+"  Ŀ�ĵ�destination��"+ct.getDestination()
//								    		+"  ���ʱ��OffDate:"+ct.getOffDate()+"  �۸�price:"+ct.getPrice()+"  ����allowance:"+ct.getAllowance());
//								}
//							    else
//							    	System.out.println("�û�Ʊ�����ڣ�");
//							}
//							break;
//						case 2: //ɾ----���ݻ�Ʊidɾ����Ʊ������Ϣ				
//							System.out.println("������Ҫɾ���Ļ�Ʊid��");
//							tid = br.readLine();
//							if(tdao.deleteTicketById(tid))
//								System.out.println("ɾ���ɹ���");
//							break;
//						case 3:	//��----��ӻ�Ʊ�����¼
//							String fightNumber = null;
//							String destination = null;
//							String offDate = null;
//							String price = null;
//							String allowance0 = null;
//							int allowance;
//							System.out.println("������Ҫ��ӻ�Ʊ����Ϣ��");
//							System.out.print("�������Ʊtid��");tid = br.readLine();
//							System.out.print("�����뺽��ţ�");fightNumber = br.readLine();
//							System.out.print("������Ŀ�ĵأ�");destination = br.readLine();
//							System.out.print("���������ʱ�䣺");offDate = br.readLine();	
//							System.out.print("������۸�");price = br.readLine();
//							System.out.print("������������");
//							allowance0 = br.readLine();
//						    allowance = Integer.parseInt(allowance0);
//							System.out.print("������0��");status0 = br.readLine();
//							status = Integer.parseInt(status0);		
//							if(tdao.insertIntoTicket(tid, fightNumber, destination, offDate, price, allowance, status))
//							    System.out.println("��Ʊ��¼����ɹ���");
//							break;
//						case 4:	//��------����id�޸Ļ�Ʊ���ʱ��
//							System.out.println("�������Ʊid");
//					        tid = br.readLine();
//					        System.out.println("�������޸ĵ����ʱ��");
//					        offDate = br.readLine();
//					        if(tdao.updateTicketById(offDate, tid))
//					            System.out.println("���³ɹ���");
//							break;
//						case 5:
//							fl3 = false;
//							System.out.println("���˳��Ի�Ʊ����Ϣ�������");
//							break;
//					}
//				}
//
//				break;
//			case 4: //�˳�
//				fl = false;
//				System.out.println("���˳���");
//				break;
//			}			
//		}
//						
//	}

}
