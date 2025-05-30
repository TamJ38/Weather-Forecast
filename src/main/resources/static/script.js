function loadForecast() {
    const city = document.getElementById('city-select').value;

    fetch(`http://localhost:8080/api/forecast/${city}`)
        .then(response => response.json())
        .then(data => renderForecast(data))
        .catch(error => console.error("Error loading forecast:", error));
}

function renderForecast(data) {
    const output = document.getElementById('forecast');
    output.innerHTML = `
        <h2>Forecast for ${data[0]?.city || "Unknown"}</h2>
        <table>
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Max Temp (°C)</th>
                    <th>Above 25°C</th>
                    <th>Rainy</th>
                </tr>
            </thead>
            <tbody>
                ${data.map(day => `
                    <tr class="${day.above25 ? 'hot' : ''} ${day.rainy ? 'rainy' : ''}">
                        <td>${day.date}</td>
                        <td>${day.maxTemperature}</td>
                        <td>${day.above25 ? 'Yes' : 'No'}</td>
                        <td>${day.rainy ? 'Yes' : 'No'}</td>
                    </tr>
                `).join("")}
            </tbody>
        </table>
    `;
}
