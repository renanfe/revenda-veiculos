package br.com.revendaveiculo.adapter.driver;

import br.com.revendaveiculo.adapter.driver.form.VeiculoForm;
import br.com.revendaveiculo.adapter.driver.form.VendaForm;
import br.com.revendaveiculo.adapter.utils.VeiculoMapper;
import br.com.revendaveiculo.adapter.utils.VendaMapper;
import br.com.revendaveiculo.core.application.service.VeiculoService;
import br.com.revendaveiculo.core.domain.Veiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService=veiculoService;
    }

    @PostMapping()
    public ResponseEntity<String> cadastrarVeiculo(final @RequestBody VeiculoForm veiculoForm) {
        try{
            veiculoService.criarVeiculo(VeiculoMapper.veiculoFormToVeiculo(veiculoForm));
            return ResponseEntity.ok("Atualizado com sucesso");
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarVeiculo(final @RequestBody VeiculoForm veiculoForm, final @PathVariable UUID id) {
        try{
            veiculoService.atualizarVeiculo(id, VeiculoMapper.veiculoFormToVeiculo(veiculoForm));
            return ResponseEntity.ok("Atualizado com sucesso");
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}/vender")
    public ResponseEntity<String> venderVeiculo(final @PathVariable UUID id, final @RequestBody VendaForm vendaForm) {
        try{
            Veiculo veiculo = veiculoService.venderVeiculo(id, VendaMapper.vendaFormToVenda(vendaForm));
            return ResponseEntity.ok("Vendido com sucesso");
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/venda")
    public ResponseEntity<List<Veiculo>> listarVeiculosVenda(){
        try{
            List<Veiculo> lstVeiculo = veiculoService.listarVeiculo(false);
            return ResponseEntity.ok(lstVeiculo);
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/vendidos")
    public ResponseEntity<List<Veiculo>> listarVeiculosVendidos(){
        try{
            List<Veiculo> lstVeiculo = veiculoService.listarVeiculo(true);
            return ResponseEntity.ok(lstVeiculo);
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> consultarVeiculo(final @PathVariable UUID id) {
        try{
            Optional<Veiculo> veiculo = veiculoService.retornarVeiculo(id);
            return veiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
    }

}
