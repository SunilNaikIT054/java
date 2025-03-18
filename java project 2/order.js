function getOrderDetails() {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    return cart;
}

function displayOrderDetails() {
    const orderDetails = getOrderDetails();
    const orderDetailsDiv = document.getElementById('order-details');
    orderDetailsDiv.innerHTML = '';

    orderDetails.forEach((item, index) => {
        orderDetailsDiv.innerHTML += `
            <div class="order-item">
                <p><strong>Cocktail Name:</strong> ${item.name}</p>
                <p><strong>Ingredients:</strong> ${item.ingredients.join(', ')}</p>
                <p><strong>Extra Ingredients:</strong> ${item.extraIngredients}</p>
                <p><strong>Special Instructions:</strong> ${item.specialInstructions}</p>
                <button onclick="removeItem(${index})">Remove Item</button>
                <hr>
            </div>
        `;
    });
}

function goBack() {
    window.history.back();
}

function addMoreItems() {
    window.location.href = 'cocktail.html';
}

function removeItem(index) {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart.splice(index, 1);
    localStorage.setItem('cart', JSON.stringify(cart));
    displayOrderDetails();
}

function finalizeOrder() {
    window.location.href = 'final.html';
}

window.onload = displayOrderDetails;