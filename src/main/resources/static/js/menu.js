document.addEventListener('DOMContentLoaded', function () {
	const menuToggle = document.getElementById('menuToggle');
	const navContainer = document.getElementById('navContainer');

	if (menuToggle && navContainer) {
		menuToggle.addEventListener('click', function () {
			navContainer.classList.toggle('active');
		});
	}

	const fadeElements = document.querySelectorAll('.fade-in');
	fadeElements.forEach((el) => {
		el.style.opacity = '0';
		setTimeout(() => {
			el.style.opacity = '1';
		}, 100);
	});

	const deleteButtons = document.querySelectorAll('.button-danger');
	deleteButtons.forEach((button) => {
		button.addEventListener('click', function (e) {
			if (!confirm('¿Está seguro que desea eliminar este elemento?')) {
				e.preventDefault();
			}
		});
	});
});