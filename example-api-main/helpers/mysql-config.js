const mysql = require('mysql');

const pool = mysql.createPool({
    host : 'tec-tc2005b.cprdpjtiiazh.us-east-1.rds.amazonaws.com',
    user : 'admin',
    password: 'rootroot',
    database: 'metaverse'
});

pool.getConnection((err,connection)=> {
    if(err)
        throw err;
    console.log('Database connected successfully');
    connection.release();
});

module.exports = pool;