/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double>): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 *
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 *
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")
            }
        }
        else{
            println("Não foi possível mostrar as notas da matéria ${materia}")
        }

        println()
    }


}

/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(){ }


/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia:String, vararg nota:Double){}


fun main() {
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    adicionarDisciplina("Matemática", mutableListOf(8.0, 7.5, 9.0))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(materia = "Português", notas = mutableListOf(6.5, 8.0, 7.0))

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão.
    // Dica: utilize mutableListOf()
    fun adicionarDisciplinaComNotasPadrao(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
        return adicionarDisciplina(materia, notas)
    }
    adicionarDisciplinaComNotasPadrao("História")

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("Geografia", mutableListOf())

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("Matemática", 7.0)
    adicionarNota("Português", 6.0)
    adicionarNota("História", 8.5)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    println("Notas das disciplinas:")
    for (materia in materiasENotas.keys) {
        mostrarNotas(materia)
    }

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("Ciências", mutableListOf())

    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    fun adicionarVariasNotas(materia: String, vararg notas: Double): Boolean {
        for (nota in notas) {
            if (!adicionarNota(materia, nota)) return false
        }
        return true
    }

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Ciências", 7.5, 8.0, 9.0)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    println("Notas de Ciências:")
    mostrarNotas("Ciências")

    // Bônus:

    // 11: calcularMedia -> Implemente a função calcularMedia()
    fun calcularMedia(notas: List<Double>): Double {
        return if (notas.isNotEmpty()) {
            notas.sum() / notas.size
        } else {
            0.0
        }
    }

    // 12: calcularMedia -> calcule a media de 2 disciplinas
    val mediaMatematica = calcularMedia(materiasENotas["Matemática"] ?: listOf())
    val mediaPortugues = calcularMedia(materiasENotas["Português"] ?: listOf())
    println("Média de Matemática: $mediaMatematica")
    println("Média de Português: $mediaPortugues")

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    fun mostrarNotasComMedia(materia: String) {
        mostrarNotas(materia)
        val notas = materiasENotas[materia] ?: return
        val media = calcularMedia(notas)
        println("Média: $media")
    }

    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    println("Notas de Matemática com média:")
    mostrarNotasComMedia("Matemática")
}
