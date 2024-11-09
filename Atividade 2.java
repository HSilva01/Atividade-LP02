from datetime import datetime

class Aluno:
    def __init__(self, nome):
        self.nome = nome
        self.notas = []
        self.nota_recuperacao = None
        self.media = None
        self.status = "SN"  # Inicialmente sem status (sem nota)
    
    def adicionar_notas(self, nota1, nota2, nota3):
        self.notas = [nota1, nota2, nota3]
        self.atualizar_status()

    def calcular_media(self, pesos=None):
        if pesos and len(pesos) == 3:
            self.media = sum(n * p for n, p in zip(self.notas, pesos)) / sum(pesos)
        else:
            self.media = sum(self.notas) / len(self.notas)
        return self.media

    def atualizar_status(self):
        self.calcular_media()
        if self.media >= 7:
            self.status = "Aprovado"
        elif self.media >= 2.5:
            self.status = "Recuperação"
        else:
            self.status = "Reprovado"
        return self.status

    def adicionar_nota_recuperacao(self, nota):
        if self.status == "Recuperação":
            self.nota_recuperacao = nota
            if self.nota_recuperacao >= 5:
                self.status = "Aprovado"
            else:
                self.status = "Reprovado"
        else:
            print(f"O aluno {self.nome} não está em recuperação.")

class Professor:
    def __init__(self, nome, is_coordenador=False):
        self.nome = nome
        self.is_coordenador = is_coordenador

    def modificar_nota(self, aluno, nova_nota, indice_nota, turma):
        if indice_nota < 1 or indice_nota > 3:
            print("Índice de nota inválido. Escolha 1, 2 ou 3.")
            return
        indice_nota -= 1  # Ajusta para índice de lista
        nota_anterior = aluno.notas[indice_nota]
        aluno.notas[indice_nota] = nova_nota
        aluno.atualizar_status()
        turma.registrar_log(self, aluno, nota_anterior, nova_nota)

class Turma:
    def __init__(self, nome, professor, curso):
        self.nome = nome
        self.professor = professor
        self.curso = curso
        self.alunos = []
        self.log_modificacoes = []

    def adicionar_aluno(self, aluno):
        self.alunos.append(aluno)

    def registrar_log(self, professor, aluno, nota_anterior, nota_nova):
        timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        log_entry = {
            "data": timestamp,
            "professor": professor.nome,
            "aluno": aluno.nome,
            "nota_anterior": nota_anterior,
            "nota_nova": nota_nova
        }
        self.log_modificacoes.append(log_entry)

    def gerar_relatorio(self):
        print(f"Relatório da Turma {self.nome}")
        for aluno in self.alunos:
            print(f"Aluno: {aluno.nome}, Média: {aluno.media:.2f}, Status: {aluno.status}")

    def lista_recuperacao(self):
        print("Lista de alunos em recuperação:")
        for aluno in self.alunos:
            if aluno.status == "Recuperação":
                print(f"Aluno: {aluno.nome}, Média: {aluno.media:.2f}")

    def lista_reprovados(self):
        print("Lista de alunos reprovados:")
        for aluno in self.alunos:
            if aluno.status == "Reprovado":
                print(f"Aluno: {aluno.nome}, Média: {aluno.media:.2f}")

    def estatisticas(self):
        aprovados = sum(1 for aluno in self.alunos if aluno.status == "Aprovado")
        recuperacao = sum(1 for aluno in self.alunos if aluno.status == "Recuperação")
        reprovados = sum(1 for aluno in self.alunos if aluno.status == "Reprovado")
        print(f"Aprovados: {aprovados}, Recuperação: {recuperacao}, Reprovados: {reprovados}")

    def exibir_log(self):
        print("Histórico de Modificações:")
        for log in self.log_modificacoes:
            print(f"{log['data']} - Professor {log['professor']} modificou a nota de {log['aluno']}: "
                  f"{log['nota_anterior']} -> {log['nota_nova']}")

class Curso:
    def __init__(self, nome, coordenador):
        self.nome = nome
        self.coordenador = coordenador
        self.turmas = []

    def adicionar_turma(self, turma):
        self.turmas.append(turma)

    def exibir_informacoes(self):
        print(f"Curso: {self.nome}, Coordenador: {self.coordenador.nome}")
        for turma in self.turmas:
            print(f"Turma: {turma.nome}, Professor: {turma.professor.nome}")
