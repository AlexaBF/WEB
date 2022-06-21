const mysql = require('mysql');

const pool = mysql.createPool({
    host : 'endpointbasededatos',
    user : 'usuariodeadministrador',
    password: 'contraseña',
    database: 'nombrebasededatos'
});

pool.getConnection((err,connection)=> {
    if(err)
        throw err;
    console.log('Database connected successfully');
    connection.release();
});

module.exports = pool;
