package data.com_data;

import data.com_data.comdata;

public class sql_data {
	comdata comd= new comdata();
	public String[] fullParentIdAnduserId(){
		String [] fullParentIdAnduserId={"from user_info WHERE account='"+comd.base_user()[0]+"';","fullParentId,userId"};
		return fullParentIdAnduserId;
	}
	public String[] account_center_mess_number(String fullParentId,String userId){
		String [] mess_number ={"FROM `user_message` AS um LEFT JOIN user_info AS ui ON um.userId=ui.userId WHERE ui.fullParentId LIKE '"+fullParentId+""+""+userId+""+"%' OR ui.userId='"+userId+"';","COUNT(*)"};
		return mess_number;
	}
	public static void main(String[] args){
		sql_data sqld=new sql_data();
		String fullParentId="1,";
		String userId="12875";
		System.out.println(sqld.account_center_mess_number(fullParentId, userId)[1]);
	}

}
