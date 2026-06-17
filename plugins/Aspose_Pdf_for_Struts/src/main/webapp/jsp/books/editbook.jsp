<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
	<h2>
		<img src="images/aspose-struts-logo.jpg" alt="Aspose.Pdf for Java"> Aspose.Pdf Struts Example -
		Simple Book Store App
	</h2>

	<b>Edit Book</b>
	<s:form action="updatebook" method="post">
		<table style="background-color: red; border: 1px solid black">
			<tr>
				<td>Book Id</td>
				<td><s:textfield name="bookId" readonly="true" /></td>
			</tr>
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
			<s:submit value="Update Book" />
		</p>
	</s:form>
</body>
</html>
