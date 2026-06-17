<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
	<h2>
		<img src="images/aspose-struts-logo.jpg" alt="Aspose.Pdf for Java"> Aspose.Pdf Struts Example -
		Simple Book Store App
	</h2>

	<b>Add Book</b>
	<s:form action="savebook" method="post">
		<table style="background-color: red; border: 1px solid black">
			<tr>
				<td>Book Name</td>
				<td><s:textfield name="bookName" /></td>
			</tr>
			<tr>
				<td>Author Name</td>
				<td><s:textfield name="authorName" /></td>
			</tr>
			<tr>
				<td>Book Cost</td>
				<td><s:textfield name="bookCost" /></td>
			</tr>
		</table>
		<p>
			<s:submit value="Save Book" />
		</p>
	</s:form>
</body>
</html>
