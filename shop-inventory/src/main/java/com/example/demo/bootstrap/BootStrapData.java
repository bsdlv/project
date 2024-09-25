package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
	private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, InhousePartRepository inhousePartRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
		this.inhousePartRepository = inhousePartRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
		List<InhousePart>inhouseParts=(List<InhousePart>)inhousePartRepository.findAll();
		List<OutsourcedPart>outsourcedParts=(List<OutsourcedPart>)outsourcedPartRepository.findAll();
		List<Product> products = (List<Product>) productRepository.findAll();

		if(inhouseParts.isEmpty()&&outsourcedParts.isEmpty()&&products.isEmpty()) {
			InhousePart in1 = new InhousePart();
			in1.setName("Salami");
			in1.setInv(5);
			in1.setPrice(10);
			in1.setId(001);
			in1.setMinInv(0);
			in1.setMaxInv(50);
			inhousePartRepository.save(in1);

			InhousePart in2 = new InhousePart();
			in2.setName("Ham");
			in2.setInv(5);
			in2.setPrice(8);
			in2.setId(002);
			in2.setMinInv(0);
			in2.setMaxInv(50);
			inhousePartRepository.save(in2);

			OutsourcedPart out1 = new OutsourcedPart();
			out1.setCompanyName("Yorkshire Farms");
			out1.setName("Provolone");
			out1.setInv(3);
			out1.setPrice(8.0);
			out1.setId(100L);
			out1.setMinInv(0);
			out1.setMaxInv(50);
			outsourcedPartRepository.save(out1);

			OutsourcedPart out2 = new OutsourcedPart();
			out2.setCompanyName("Amoroso Bakery");
			out2.setName("Bread");
			out2.setInv(12);
			out2.setPrice(2.0);
			out2.setId(101L);
			out2.setMinInv(0);
			out2.setMaxInv(50);
			outsourcedPartRepository.save(out2);

			OutsourcedPart out3 = new OutsourcedPart();
			out3.setCompanyName("Pete's Pickles");
			out3.setName("Pickles");
			out3.setInv(12);
			out3.setPrice(2.0);
			out3.setId(102L);
			out3.setMinInv(0);
			out3.setMaxInv(50);
			outsourcedPartRepository.save(out3);

			Product italian = new Product("Italian Melt", 10.0, 10);
			Product cuban = new Product("Cuban Melt", 10.0, 10);
			Product caprese = new Product("Caprese Melt", 10.0, 10);
			Product blt = new Product("BLT Melt", 10.0, 10);
			Product tuna = new Product("Tuna Melt", 10.0, 10);
			productRepository.save(italian);
			productRepository.save(cuban);
			productRepository.save(caprese);
			productRepository.save(blt);
			productRepository.save(tuna);

			inhouseParts=(List<InhousePart>)inhousePartRepository.findAll();
			outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
		}

		for(InhousePart part:inhouseParts){
			System.out.println(part.getName()+" "+part.getId());
		}
		for(OutsourcedPart part:outsourcedParts){
			System.out.println(part.getName()+" "+part.getCompanyName());
		}

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(products);
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
