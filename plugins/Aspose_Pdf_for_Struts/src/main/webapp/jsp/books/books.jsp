<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style>
.imgClass {
	background-image: url(https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSppkh09ZjwnSeBbZ4yj9Q3PjP69JD-B8OoWYkNDtnHGbHtX9oCTw);
	background-position: 0 0;
	background-repeat: no-repeat;
	background-color: transparent;
	cursor: pointer;
	width: 130px;
	height: 53px;
}
</style>
</head>
<body>
	<h2>
		<img src="images/aspose-struts-logo.jpg" alt="Aspose.Pdf for Java"> Aspose.Pdf Struts Example -
		Simple Book Store App
	</h2>

	<p>
		<s:a action="addbook">Add Book</s:a>
		|
		<s:a action="exporttopdf" cssClass="imgClass">Export to PDF</s:a>
	</p>

	<table style="background-color: #82CAFA; border: 1px solid black" width="800">
		<tr style="color: white; background-color: red">
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Author Name</th>
			<th>Book Cost</th>
			<th colspan="2">Actions</th>
		</tr>
		<s:iterator value="booksList" var="book">
			<tr style="color: white; background-color: blue">
				<td><s:property value="#book['BookId']" /></td>
				<td><s:property value="#book['BookName']" /></td>
				<td><s:property value="#book['AuthorName']" /></td>
				<td><s:property value="#book['BookCost']" /></td>
				<td>
					<s:a action="editbook">
						<s:param name="bookId" value="#book['BookId']" />
						Edit
					</s:a>
				</td>
				<td>
					<s:a action="deletebook" onclick="return checkDelete();">
						<s:param name="bookId" value="#book['BookId']" />
						Delete
					</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>

	<script>
		function checkDelete() {
			return confirm("Are you sure you want to delete this book?");
		}
	</script>
</body>
</html>
