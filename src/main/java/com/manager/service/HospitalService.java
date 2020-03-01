package com.manager.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.manager.entity.hospital.HospitalGuia;

@Service
public class HospitalService {

	@PersistenceContext
    private EntityManager manager;
	
	
	public List<HospitalGuia> hospitalGuia(String guiaNumero) {
        try {
        	
        	StringBuilder sql = new StringBuilder();
        	sql.append("select ben.id, convenio.nome as nome_convenio, ");
        	sql.append("ben.matricula, ben.nome,  ");
        	sql.append("guia.numero as numero_tb_guia,  ");
        	sql.append("item_guia.quantidade, produto.nome as nome_produto, ");
        	sql.append("produto.valor_unitario as produto_valor_unitario,  ");
        	sql.append("quitacao_guia.valor_pago as valor_pago_convenio,  ");
        	sql.append("quitacao_item.motivo_glosa_descricao  ");
        	sql.append("from beneficiario ben  ");
        	sql.append("left join guia on ben.id = guia.beneficiario_id  ");
        	sql.append("left join convenio on convenio.id = guia.convenio_id ");
        	sql.append("left join item_guia on guia.id = item_guia.guia_id  ");
        	sql.append("left join produto on item_guia.produto_id = produto.id  ");
        	sql.append("left join quitacao_guia on guia.id = quitacao_guia.guia_id  ");
        	sql.append("left join quitacao_item on item_guia.id = quitacao_item.item_guia_id ");
        	sql.append("where guia.numero = (?1)");
        	
        	
            Query query = manager.createNativeQuery(sql.toString());  
            query.setParameter(1, guiaNumero);
            List<Object[]> list = query.getResultList();
            HospitalGuia hospitalGuia;
            List<HospitalGuia> listGuia = new ArrayList<>();
            
            for (Object[] row : list) {
            	hospitalGuia = new HospitalGuia();
            	hospitalGuia.setId(Long.valueOf(row[0].toString()));
            	hospitalGuia.setNomeConvenio(row[1].toString());
            	hospitalGuia.setNome(row[3].toString());
            	hospitalGuia.setNumeroGuia(row[4].toString());
            	hospitalGuia.setQuantidadeItem(Integer.valueOf(row[5].toString()));
            	hospitalGuia.setNomeProduto(row[6].toString());
            	hospitalGuia.setValorItem(Double.parseDouble(row[7].toString()));
            	listGuia.add(hospitalGuia);
            }
            return listGuia;
        } catch(NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
