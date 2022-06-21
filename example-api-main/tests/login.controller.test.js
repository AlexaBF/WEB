const controller=require('../controllers/login.controller');
const request =require('supertest');
//aislar el código del login.controller
const express = require('express');
const app = express();
const login = require('../routes/login');
app.use(express.json());
app.use('/api/login',login);

describe('Pruebas del controlador de login',()=>{
    test('Verifica que regresa un token con un usuario válido',()=>{

        const req = {
            body:{
                user:'hugo',
                password:'123'
            }
        }
        const res = {
            output:'',
            json: function(input){
                this.output = input
            }
        }

        controller.login(req,res)

        //si el token no esta vacío si se pudo iniciar sesión
        expect(res.output.token).not.toBe('')

    })


    test('Verifica que devuelve un token vacío con un usuario no valido',async()=>{     
        //prueba con supertest
        const response = await request(app).post('/api/login').send({
            user:'hugo',
            password: '1234'
        })

        const json = JSON.parse(response.text)
        expect(response.statusCode).toBe(200)
        expect(json.token).toBe('')

    })

})