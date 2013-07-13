<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	<form action="getClassServlet" method="post">
		<input type="text" name="userId"> 
		<input type="password" name="password"> 
		<select name="method">
			<option value="xml">xml</option>
			<option value="json">json</option>
		</select>
		<select name="term">
			<option value="＝所有学期＝">＝所有学期＝</option>
			<option value="1999/2000(1)">1999/2000(1)</option>
			<option value="1999/2000(2)">1999/2000(2)</option>
			<option value="2000/2001(1)">2000/2001(1)</option>
			<option value="2000/2001(2)">2000/2001(2)</option>
			<option value="2001/2002(1)">2001/2002(1)</option>
			<option value="2001/2002(2)">2001/2002(2)</option>
			<option value="2002/2003(1)">2002/2003(1)</option>
			<option value="2002/2003(2)">2002/2003(2)</option>
			<option value="2003/2004(1)">2003/2004(1)</option>
			<option value="2003/2004(2)">2003/2004(2)</option>
			<option value="2004/2005(1)">2004/2005(1)</option>
			<option value="2004/2005(2)">2004/2005(2)</option>
			<option value="2005/2006(1)">2005/2006(1)</option>
			<option value="2005/2006(2)">2005/2006(2)</option>
			<option value="2006/2007(1)">2006/2007(1)</option>
			<option value="2006/2007(2)">2006/2007(2)</option>
			<option value="2007/2008(1)">2007/2008(1)</option>
			<option value="2007/2008(2)">2007/2008(2)</option>
			<option value="2008/2009(1)">2008/2009(1)</option>
			<option value="2008/2009(2)">2008/2009(2)</option>
			<option value="2009/2010(1)">2009/2010(1)</option>
			<option value="2009/2010(2)">2009/2010(2)</option>
			<option value="2010/2011(1)">2010/2011(1)</option>
			<option value="2010/2011(2)">2010/2011(2)</option>
			<option value="2011/2012(1)">2011/2012(1)</option>
			<option value="2011/2012(2)">2011/2012(2)</option>
			<option value="2012/2013(1)">2012/2013(1)</option>
			<option value="2012/2013(2)">2012/2013(2)</option>
			<option value="2098/2099(1)">2098/2099(1)</option>
			<option value="2013/2014(1)">2013/2014(1)</option>
			<option value="2013/2014(2)">2013/2014(2)</option>
			<option value="2014/2015(1)">2014/2015(1)</option>
			<option value="2014/2015(2)">2014/2015(2)</option>
			<option value="2015/2016(1)">2015/2016(1)</option>
			<option value="2015/2016(2)">2015/2016(2)</option>
		</select> 
		<input type="submit" value="查询">
	</form>

</body>
</html>
