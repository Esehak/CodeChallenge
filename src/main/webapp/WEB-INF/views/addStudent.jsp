<%@ include file="header.jsp"%>

		<a href="<c:url value="/" />" class="btn btn-danger btn-mini ">Home</a>
		<a href="<c:url value="/list" />" class="btn btn-danger btn-mini ">View	all students</a>
		<a href="<c:url value="/import" />" class="btn btn-danger btn-mini ">Import Students</a>
	</div>
</section>
<section class="container">
	<form:form modelAttribute="newStudent" method='POST'
		class="form-horizontal">
		<fieldset>
			<legend>Add new student</legend>

			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="schoolYear">
					school year</label>
				<div class="col-lg-10">
					<form:input id="schoolYear" path="schoolYear" type="text"
						placeholder="Ex:2019" class="form:input-large" />
					<form:errors path="schoolYear" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="campusID">campus
					ID</label>
				<div class="col-lg-10">
					<form:input id="campusID" path="campusID" type="text"
						class="form:input-large" />
					<form:errors path="campusID" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="studentID">student
					ID</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="studentID" path="studentID" type="text"
							class="form:input-large" />
						<form:errors path="studentID" cssClass="text-danger" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="entryDate">entry
					Date</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="entryDate" path="entryDate" type="text"
							class="form:input-large" />
						<form:errors path="entryDate" cssClass="text-danger" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="gradeLevel">grade
					Level</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="gradeLevel" path="gradeLevel" type="text"
							class="form:input-large" />
						<form:errors path="gradeLevel" cssClass="text-danger" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="name">name</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="name" path="name" type="text"
							class="form:input-large" />
						<form:errors path="name" cssClass="text-danger" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="save" />
				</div>
			</div>

		</fieldset>
	</form:form>


	<%@ include file="footer.jsp"%>