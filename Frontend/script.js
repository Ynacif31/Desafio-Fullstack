const API_URL = 'http://localhost:8080/products';

// Função para buscar produtos da API e exibir na tabela
async function fetchProducts() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error('Erro ao buscar produtos.');

        const products = await response.json();
        displayProducts(products); // Renderiza os produtos na tabela
    } catch (error) {
        console.error('Erro ao buscar produtos:', error);
        alert('Não foi possível carregar os produtos.');
    }
}

// Função para exibir produtos na tabela
function displayProducts(products) {
  const tableBody = document.getElementById('product-table-body');
  tableBody.innerHTML = ''; // Limpa a tabela antes de renderizar

  if (products.length === 0) {
      const row = `<tr><td colspan="2">Nenhum produto encontrado.</td></tr>`;
      tableBody.innerHTML = row;
      return;
  }

  products.forEach(product => {
      const row = `
          <tr>
              <td>${product.name}</td>
              <td>R$ ${parseFloat(product.price).toFixed(2)}</td>
          </tr>
      `;
      tableBody.innerHTML += row;
  });
}

// Função para cadastrar um novo produto na API
async function createProduct(event) {
    event.preventDefault(); // Evita o reload padrão do formulário

    const name = document.getElementById('product-name').value;
    const description = document.getElementById('product-description').value;
    const price = parseFloat(document.getElementById('product-price').value);
    const disponibilidade = document.getElementById('product-disponibilidade').value;

    const product = { name, description, price, disponibilidade };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(product),
        });

        if (!response.ok) throw new Error('Erro ao cadastrar produto.');

        alert('Produto cadastrado com sucesso!');
        window.location.href = 'listagem.html'; // Redireciona para a página de listagem
    } catch (error) {
        console.error('Erro ao cadastrar produto:', error);
        alert('Não foi possível cadastrar o produto.');
    }
}

// Adiciona evento para o formulário de cadastro
const form = document.getElementById('product-form');
if (form) {
    form.addEventListener('submit', createProduct);
}

// Carrega a lista de produtos ao abrir a página de listagem
document.addEventListener('DOMContentLoaded', () => {
    if (document.getElementById('product-table-body')) {
        fetchProducts();
    }
});