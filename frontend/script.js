const url = 'https://localhost:8080/cliente'

fetch(url)
    .then(response =>{
        if(!response.ok){
            throw new Error('Erro ao carregar os dados')
        }
        return response.json()
    })
    .then(data =>{
        console.log(data)
    })
    .catch(error => {
        console.error('Erro', error)
    })