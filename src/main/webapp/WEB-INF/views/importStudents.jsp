<%@ include file="header.jsp"%>
<a href="<c:url value="/" />" class="btn btn-danger btn-mini ">Home</a>
<a href="<c:url value="/add" />" class="btn btn-danger btn-mini ">Add a new Student</a>
<a href="<c:url value="/list" />" class="btn btn-danger btn-mini ">View	all Students</a>
</div>
</section>


<div>
	<form method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td>File to upload:</td> <td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td></td> <td><input type="submit" value="Upload" /></td>
			</tr>
		</table>
	</form>
</div>



<%@ include file="footer.jsp"%>
