$(document).ready(function() {

	// SUBMIT FORM
	$("#searchbtn").click(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});

	
})

function ajaxPost() {
	var searchCriterian = {};

	// PREPARE FORM DATA
	var formData = {
		schoolYear : $("#schoolYearInput").val(),
		campusID : $("#campusIDInput").val(),
		studentID : $("#studentIDInput").val(),
		entryDate : $("#entryDateInput").val(),
		gradeLevel : $("#gradeLevelInput").val(),
		name : $("#nameInput").val(),
	}

	// DO POST
	$.post(window.location + "/search", formData, function(data) {
				var json = data;
			},'json')
			.done(
					function(students) {
						if (students.length > 0) {
							$("#studentsDiv")
									.html(displayStudents(students));
						} else {
							$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>"
									+ "No Student found <br></p>");
							$("#studentsDiv")
							.html("");
						}
					}).fail(function(e) {
						$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>"
								+ "Error Retrieving students <br></p>");
						$("#studentsDiv")
						.html("");
			});

}

function resetData() {
	$("#schoolYearInput").val("");
	$("#campusIDInput").val("");
	$("#studentIDInput").val("");
	$("#entryDateInput").val("");
	$("#gradeLevelInput").val("");
	$("#nameInput").val("");
}

function displayStudents(students){
	var studentTable = "";
	studentTable = "<table id=\"studentList\""+
			+"class=\"table thead-dark table-striped table-bordered table-hover table-sm\">" +
			"<tr>"+
					"<th>School Year</th>"+
					"<th>Campus</th>"+
					"<th>Student ID</th>"+
					"<th>Entry Date</th>"+
					"<th>Grade Level</th>"+
					"<th>Name</th>"+
				"</tr>";
	for(var student of students){
		studentTable = studentTable + 
					"<tr>"+
						"<td>"+student.schoolYear+"</td>"+
						"<td>"+student.campusID+"</td>"+
						"<td>"+student.studentID+"</td>"+
						"<td>"+student.entryDate+"</td>"+
						"<td>"+student.gradeLevel+"</td>"+
						"<td>"+student.name+"</td>"+
						"<td><a href=\"/edit/"+student.id+" \" class=\"btn btn-danger btn-mini\">Edit</a></td>"+
					"</tr>"
	}
	studentTable = studentTable + "</table>";
	return studentTable;
}