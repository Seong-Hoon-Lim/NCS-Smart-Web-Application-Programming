<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.Account"%>
<%@ page import="service.AccountService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/index.css">
<link rel="stylesheet" href="../css/accService.css">
</head>
<body>
<%
	ArrayList<Account> accs = new ArrayList<Account>();
	AccountService aService = new AccountService();
	
	String myid = (String) session.getAttribute("id");
	System.out.println(myid);
	accs = aService.findmyAccount(myid);
	
%>

 <div id="wrap">
 	<jsp:include page="../incl/banner.jsp"/>
 	
 	<div id="main">
 		<div >
		<%
			for (int i = 0; i < accs.size(); i++) {
				Account acc = accs.get(i);
			%>
			<div id="listwrap">
				<ul>
					<li>���¹�ȣ : <%=acc.getAccountNum()%></li>
					<li>�ܾ� : <%=acc.getBalance()%></li>
					<li>�������� : <%=acc.getAccountType()%></li>
				</ul> 
				
				<form method="post" name="accService">
					<input type="text" value="<%=acc.getAccountNum()%>" name="accNum" id="textInput">
					<input type="submit" formaction="./depositForm.jsp" value="�Ա�" name="deposit" class="btn">
					<input type="submit" formaction="./withdrawForm.jsp" value="���" name="withdraw" class="btn">
					<input type="submit" formaction="./transferForm.jsp" value="�۱�" name="transfer" class="btn">
					<input type="submit" formaction="removeaccount.jsp" value="���»���" name="delete" class="btn">
				</form>
				
			</div>
		<%
		}
		%></div>
 	

	</div>
 	

 	
 	<jsp:include page="../incl/copyright.jsp"/>	
 
 </div>

</body>
</html>