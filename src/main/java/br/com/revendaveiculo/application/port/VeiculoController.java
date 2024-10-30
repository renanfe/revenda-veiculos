package br.com.revendaveiculo.application.port;

import br.com.revendaveiculo.application.port.input.VeiculoUseCase;
import br.com.revendaveiculo.application.port.request.body.VeiculoForm;
import br.com.revendaveiculo.application.port.request.body.VendaForm;
import br.com.revendaveiculo.infrastructure.adapter.output.persistence.mapper.VeiculoMapper;
import br.com.revendaveiculo.infrastructure.adapter.output.persistence.mapper.VendaMapper;
import br.com.revendaveiculo.domain.model.Veiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/veiculos")
public class VeiculoController {

    private final VeiculoUseCase veiculoUseCase;

    public VeiculoController(VeiculoUseCase veiculoUseCase){
        this.veiculoUseCase = veiculoUseCase;
    }

    @PostMapping()
    public ResponseEntity<String> cadastrarVeiculo(final @RequestBody VeiculoForm veiculoForm) {
        try{
            veiculoUseCase.criarVeiculo(VeiculoMapper.veiculoFormToVeiculo(veiculoForm));
            return ResponseEntity.ok("Atualizado com sucesso");
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarVeiculo(final @RequestBody VeiculoForm veiculoForm, final @PathVariable UUID id) {
        try{
            veiculoUseCase.atualizarVeiculo(id, VeiculoMapper.veiculoFormToVeiculo(veiculoForm));
            return ResponseEntity.ok("Atualizado com sucesso");
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}/vender")
    public ResponseEntity<String> venderVeiculo(final @PathVariable UUID id, final @RequestBody VendaForm vendaForm) {
        try{
            Veiculo veiculo = veiculoUseCase.venderVeiculo(id, VendaMapper.vendaFormToVenda(vendaForm));
            return ResponseEntity.ok("Vendido com sucesso");
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/venda")
    public ResponseEntity<List<Veiculo>> listarVeiculosVenda(){
        try{
            List<Veiculo> lstVeiculo = veiculoUseCase.listarVeiculo(false);
            return ResponseEntity.ok(lstVeiculo);
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/vendidos")
    public ResponseEntity<List<Veiculo>> listarVeiculosVendidos(){
        try{
            List<Veiculo> lstVeiculo = veiculoUseCase.listarVeiculo(true);
            return ResponseEntity.ok(lstVeiculo);
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> consultarVeiculo(final @PathVariable UUID id) {
        try{
            Optional<Veiculo> veiculo = veiculoUseCase.retornarVeiculo(id);
            return veiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

}
