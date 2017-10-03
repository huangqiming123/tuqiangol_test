package data.comdata;

public class AssertData {
	public String[] account_center_msg_center_title(){
		String[] title={"消息中心"};
		return title;
	}
	public String[] accountCenterMsgCenterGetFirstReadStatus(){
		String []getFirstReadStatus={"已读"};
		return getFirstReadStatus;
	}
	public String[] accountCenterMsgCenterGetSetReadStatusText(){
		String [] getSetReadStatusText={"操作成功"};
		return getSetReadStatusText;
		}
	public String[] accountCenterMsgSetReadStatusTextWhileNumIsNull(){
		String [] textWhileNumIsNull={"没有消息"};
		return textWhileNumIsNull;
	}
	public String[] accountCenterFictitiousAccountTitle(){
		String [] fictitiousAccountTitle={"虚拟账号管理"};
		return fictitiousAccountTitle;
	}
	public String[] accountCenterFictitiousAccountTip(){
		String [] FictitiousAccountTip={"账号只能包含中文、数字、字母、下划线、@"};
		return FictitiousAccountTip;
	}
	public String[] accountCenterFictitiousPaawordTip(){
		String [] FictitiousPasswordTip={"密码格式错误，必须为字母和数字的组合"};
		return FictitiousPasswordTip;
	}
	public String[] accountCenterFictitiousRePaawordTip(){
		String [] FictitiousRePasswordTip={"两次输入的密码不一致"};
		return FictitiousRePasswordTip;
	}

}
