<p align="center">
	<img src="./Logo.png" width="50%"/>
</p>
<h3>A simple application for managing quotes. It allows users to:</h3>

<li>Add quotes via POST requests, storing them in both Redis (for caching) and PostgreSQL (for persistent storage).</li>
<li>Retrieve a specific quote by its ID.</li>
<li>Fetch all quotes by a specified author.</li><br>

Built for demonstration of <b>Redis</b>, <b>Kafka</b> & <b>Postrgres</b> usage all composed in <b>Docker Containers.<b>

<h2>Requirements</h2>
Docker setup on machine (i.e. Docker Desktop)<br>
Cloned or Downloaded repository

<h2>Run command</h2>
docker compose up --build -d
