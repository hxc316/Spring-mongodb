import boot.spring.Application;
import boot.spring.dao.PictureRepository;
import boot.spring.po.Picture;
import boot.spring.service.PictureService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class BaseTest {

    @Resource(name = "mongodbServiceImpl")
    PictureService pictureService;
    @Autowired
    private PictureRepository pictureRepository;

    @Test
    public void get(){
        Picture picture = pictureService.getPictureByid("5d243f1a939e1b4db4ac0a851");
        System.out.println(" >>>>> data : " + new Gson().toJson(picture));
    }

    @Test
    public void s2(){
        Picture pic = new Picture();
        pic.setFilename("fn111");
        pic.setPath("d001");
        pic.setSize(100l);
        pictureRepository.insert(pic);
    }

    @Test
    public void s3(){
        PageRequest request = new PageRequest(1,2);
        Page<Picture> pictures = pictureRepository.findAll(request);
//        System.out.println(" >>>>> pictures.getContent() :" + new Gson().toJson(pictures.getContent()));

        List<Picture> pictureList = pictureRepository.findByFilenameContaining("zz");

        System.out.println(">>>>> pictures :" + new Gson().toJson(pictureList));

    }

}
