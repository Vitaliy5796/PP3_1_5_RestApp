const deleteForm = document.getElementById('deleteForm');
const delete_id = document.getElementById('delete_id');
const delete_username = document.getElementById('delete_username');
const delete_age = document.getElementById('delete_age');
const delete_email = document.getElementById('delete_email');
const delete_password = document.getElementById('delete_password');


async function deleteModal(id) {
    const urlDelete = 'http://localhost:8080/api/admin/' + id;
    let modalDelete = await fetch(urlDelete);
    if (modalDelete.ok) {
        let userData =
            await modalDelete.json().then(user => {
                delete_id.value = `${user.id}`;
                delete_username.value = `${user.username}`;
                delete_age.value = `${user.age}`;
                delete_email.value = `${user.email}`;
            })
    } else {
        alert(`Error, ${modalDelete.status}`)
    }
}

async function deleteUser() {
    deleteForm.addEventListener('submit', deletingUser);

    function deletingUser(event) {
        event.preventDefault();
        let urlDeleting = '/api/admin/' + delete_id.value;
        let method = {
            method: 'DELETE',
            headers: {
                "Content-Type": "application/json"
            }
        }

        fetch(urlDeleting, method).then(() => {
            $('#deleteForm_closeButton').click();
            getAdmin();
        });
    }
}
