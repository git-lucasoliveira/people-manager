package com.starcard.starpeople.controller;

import com.starcard.starpeople.model.Setor;
import com.starcard.starpeople.repository.SetorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SetorController {

    private final SetorRepository repository;

    public SetorController(SetorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/setores")
    public String listarSetores(Model model) {
        // Puxa todos setores que estão no banco
        model.addAttribute("setores", repository.findAll());
        return "setores/lista";
    }

    @GetMapping("/setores/novo")
    public String abrirFormulario(Model model) {
        // Envia um papel em branco para o formulario preencher
        model.addAttribute("setor", new Setor());
        return "setores/formulario"; // Vai procurar o arquivo formulario.html
    }

    @PostMapping("/setores/salvar")
    public String salvarSetor(Setor setor) {
        // 1. O Spring recebe o objeto 'setor' preenchido pelo formulário

        // 2. Mandamos o repositório salvar (INSERT/UPDATE no SQL)
        repository.save(setor);

        // 3. Redirecionamos para a lista, para você ver o novo item lá
        return "redirect:/setores";
    }

    @GetMapping("/setores/excluir/{id}")
    public String excluirSetor(@PathVariable Long id) {

        // @PathVariable diz: "Pegue o número que esta na URL e jogue na variavel 'id'

        //2. Mandamos o almoxarife apagar esse ID específico
        repository.deleteById(id);

        //3. Voltamos para lista (que agora terá um item a menos)
        return "redirect:/setores";
    }

    @GetMapping("/setores/editar/{id}")
    public String editarSetor(@PathVariable Long id, Model model) {
        //1. Busca o setor no banco pelo ID (ou mostra erro se não char)
        Setor setorExistente = repository.findById(id).orElseThrow();

        //2. Manda o setor preenchido para a View
        model.addAttribute("setor", setorExistente);

        //3. Reaproveita o mesmo formulario de cadastro
        return "setores/formulario";
    }
}
