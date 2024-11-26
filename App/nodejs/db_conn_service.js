
const { Client } = require('pg');

const client = new Client({
    user: 'postgres',
    password: 'postgres',
    host: 'postgres',
    port: 5432,
    database: 'pilates_db',
});

client 
    .connect()
    .then(() => {console.log('Connected to PostgreSQL database.')
})
.catch((err) => {
    console.error('Error connecting to PostgreSQL database:', err);
});

