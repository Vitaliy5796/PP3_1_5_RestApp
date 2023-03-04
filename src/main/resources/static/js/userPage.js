const urlUser = '/api/user';

async function getUserPage() {
    let page = await fetch(urlUser);

    if (page.ok) {
        let user = await page.json();
        getInformationAboutUser(user);
    } else {
        alert(`Error, ${page.status}`)
    }
}

function getInformationAboutUser(user) {
    let roles = [];
    for (let role of user.roles) {
        roles.push(' ' + role.role.toString().replaceAll('ROLE_', ''));
    }
    let tr = document.createElement('tr');
    tr.innerHTML =
        `<tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.age}</td>
        <td>${user.email}</td>
        <td>${roles}</td>
    </tr>`

    document.getElementById(`tbody_user`).append(tr);
}

getUserPage();