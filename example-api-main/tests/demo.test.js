//describe <- crear categoria de pruebas
//test <- crear cada una de las pruebas

describe("Pruebas de ejecución de funciones base",()=>{
    test('verifica si la suma de dos numeros es un número entero',()=>{
        //expect es como un if
        expect(typeof(2+3)).toBe(typeof(9))
    })
    test('Verifica que la función esPar devuelve true para un número par',()=>{
        const esPar=(numero)=>{
            return numero % 2 == 0;
        }

        expect(esPar(2)).toBe(true)

    })
})