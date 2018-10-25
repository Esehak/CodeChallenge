
<%@ include file="header.jsp"%>

<a href="<c:url value="/" />" class="btn btn-danger btn-mini ">Home</a>
<a href="<c:url value="/add" />" class="btn btn-danger btn-mini ">Add	a new Student</a>
<a href="<c:url value="/import" />" class="btn btn-danger btn-mini ">Import	Students</a>

</div>
</section>
<div id="postResultDiv"></div>
<div style="float: left; margin-right: 40px; margin-left: 20px">
	<table>
		<tr>
			<td><label> School Year</label></td>
			<td><input style="float: right; margin-left: 5px" type="text"
				id="schoolYearInput" name="schoolYearInput" value="" /></td>
		</tr>
		<tr>
			<td><label> Campus ID</label></td>
			<td><input style="float: right; margin-left: 5px" type="text"
				id="campusIDInput" name="campusIDInput" value="" /></td>
		</tr>
		<tr>
			<td><label> Student ID </label></td>
			<td><input style="float: right; margin-left: 5px" type="text"
				id="studentIDInput" name="studentIDInput" value="" /></td>
		</tr>
		<tr>
			<td><label> Entry Date </label></td>
			<td><input style="float: right; margin-left: 5px" type="text"
				id="entryDateInput" name="entryDateInput" value="" /></td>
		</tr>
		<tr>
			<td><label> Grade Level </label></td>
			<td><input style="float: right; margin-left: 5px" type="text"
				id="gradeLevelInput" name="gradeLevelInput" value="" /></td>
		</tr>
		<tr>
			<td><label> Name </label></td>
			<td><input style="float: right" type="text" id="nameInput"
				name="nameInput" value="" /></td>
		</tr>
		<tr>
			<td><a id="resetStudents" href="<c:url value="/list" />"
			class="btn btn-danger btn-mini ">Back</a></td>
			<td><button id="searchbtn" style="float: right"
					class="btn btn-danger btn-mini">Search</button></td>
		</tr>
	</table>


</div>
<div style="width: 700px; display: inline-block">
	<form:form modelAttribute="students">
		<div id="studentsDiv">
			<table id="studentList"
				class="table thead-dark table-striped table-bordered table-hover table-sm">
				<tr>
					<th>School Year</th>
					<th>Campus</th>
					<th>Student ID</th>
					<th>Entry Date</th>
					<th>Grade Level</th>
					<th>Name</th>
				</tr>
				<c:forEach items="${students}" var="student">
					<tr>
						<td><c:out value="${student.schoolYear}" /></td>
						<td><c:out value="${student.campusID}" /></td>
						<td><c:out value="${student.studentID}" /></td>
						<td><c:out value="${student.entryDate}" /></td>
						<td><c:out value="${student.gradeLevel}" /></td>
						<td><c:out value="${student.name}" /></td>
						<td><a href="<c:url value="/edit/${student.id }" />"
							class="btn btn-danger btn-mini ">Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form:form>
</div>
<%@ include file="footer.jsp"%>