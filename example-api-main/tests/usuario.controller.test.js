const controller = require('../controllers/usuario.controller')

describe('Pruebas del controlador de usuario',()=>{
    test('verifica que al llamar getUsuario devuelve it works', () => {

        const req = {}
        const res = {
            output: '',
            json:function(input){ this.output = input}
        }
        controller.getUsuario(req,res)
        //toBe es para valores primitivos / toEqual es para arreglos u objetos
        expect(res.output).toEqual({mensaje : 'It works!'})
        
    })
})