const API="http://localhost:8080/api/jobs";

async function loadApplications(){

const res=await fetch(API);
const data=await res.json();

renderTable(data);

}

function renderTable(data){

let table=document.getElementById("tableBody");

table.innerHTML="";

data.forEach(app=>{

let hiredClass=app.status==="Hired" ? "table-success":"";

let row=`
<tr class="${hiredClass}">
<td>${app.id}</td>
<td>${app.candidateName}</td>
<td>${app.email}</td>
<td>${app.phone}</td>
<td>${app.positionApplied}</td>
<td>${app.experience}</td>
<td>${app.status}</td>
<td>${app.interviewDate || ""}</td>
<td>${app.createdDate || ""}</td>

<td>
<button class="btn btn-danger btn-sm"
onclick="deleteApp(${app.id})">
Delete
</button>
</td>

</tr>
`;

table.innerHTML += row;

});

}

async function addApplication(){

let name=document.getElementById("name").value;
let email=document.getElementById("email").value;
let phone=document.getElementById("phone").value;
let position=document.getElementById("position").value;
let experience=document.getElementById("experience").value;
let status=document.getElementById("status").value;
let interviewDate=document.getElementById("interviewDate").value;

if(!name || !email || !position){

alert("Candidate Name, Email and Position are required");
return;

}

await fetch(API,{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({
candidateName:name,
email:email,
phone:phone,
positionApplied:position,
experience:experience,
status:status,
interviewDate:interviewDate
})
});

clearForm();

loadApplications();

}

function clearForm(){

document.getElementById("name").value="";
document.getElementById("email").value="";
document.getElementById("phone").value="";
document.getElementById("position").value="";
document.getElementById("experience").value="";
document.getElementById("interviewDate").value="";

}

async function deleteApp(id){

await fetch(`${API}/${id}`,{
method:"DELETE"
});

loadApplications();

}

/* search */

document.getElementById("searchInput")
.addEventListener("keyup",async function(){

let name=this.value;

const res=await fetch(`${API}/search?name=${name}`);
const data=await res.json();

renderTable(data);

});

/* filter */

async function filterStatus(){

let status=document.getElementById("filterStatus").value;

if(status===""){

loadApplications();
return;

}

const res=await fetch(`${API}/status/${status}`);

const data=await res.json();

renderTable(data);

}

loadApplications();