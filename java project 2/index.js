// Search functionality
const searchInput = document.getElementById('searchInput');
const resultItems = document.querySelectorAll('.result-item');

searchInput.addEventListener('input', () => {
    const searchTerm = searchInput.value.toLowerCase();

    resultItems.forEach(item => {
        const name = item.getAttribute('data-name').toLowerCase();
        if (name.includes(searchTerm)) {
            item.style.display = 'block';
        } else {
            item.style.display = 'none';
        }
    });
});

// Order placement
function placeOrder(drinkName) {
    const confirmation = confirm(`Are you sure you want to order a ${drinkName}?`);
    if (confirmation) {
        alert(`${drinkName} has been added to your order!`);
    }
}

