//package com.fanle.moka.script;
//
//import com.fanle.moka.entity.mogu.domain.HqStoryEntity;
//import com.fanle.moka.mogu.respo.MoguBookRespo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/mogu")
//public class MoguScriptController {
//
//    @Autowired
//    MoguBookRespo moguBookRespo ;
////    @Autowired
////    MoguChapterRespo chapterRespo ;
//
//    @PersistenceContext
//    EntityManager entityManager ;
//
//    @RequestMapping("/updateBookLen")
//    public String updateBoonTotalChapterByBookid(){
//       List<HqStoryEntity> list = moguBookRespo.findAllByStoryAttr((byte)2);
//       for(HqStoryEntity story:list){
//           if(story.getId()!=855){
//               continue ;
//           }
//           Long len = 0L;
//           log.info("storyid:{}-----story title:{}-----len:{}",story.getId(),story.getTitle(),len);
//           story.setLen(len==null?0:len.intValue());
//       }
//
//        return "success";
//    }
//
//}
