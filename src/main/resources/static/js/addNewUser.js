const urlNewUser = 'http://localhost:8080/api/admin';
const form_addUser = document.getElementById('form_addUser');
// const role_new = document.querySelector('#select_roles').selectedOptions;


async function createNewUser(event) {
    event.preventDefault();
    // let roles = [];
    // for (let i = 0; i < role_new.length; i++) {
    //     roles.push("ROLE_" + role_new[i].value);
    // }
    let method = {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: form_addUser.username.value,
            age: form_addUser.age.value,
            email: form_addUser.email.value,
            password: form_addUser.password.value
            // roles: roles
        })
    }
    await fetch(urlNewUser, method).then(() => {
        form_addUser.reset();
        getAdmin();
        $("#nav-home-tab").click();
    });
}

form_addUser.addEventListener('submit', createNewUser);