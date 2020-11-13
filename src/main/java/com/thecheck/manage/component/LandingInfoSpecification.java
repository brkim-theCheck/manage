package com.thecheck.manage.component;
/*
 * @author brKim
 * @date 2020/11/05
 * @desc
 */

import com.thecheck.manage.model.LandingInfoEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class LandingInfoSpecification {

    public static Specification<LandingInfoEntity> searchWith(Map<String, Object> searchKeyword) {


        return (Specification<LandingInfoEntity>) ((root, query, builder) -> {
            List<Predicate> predicate = getPredicateWithKeyword(searchKeyword, root ,builder);
            return builder.and(predicate.toArray(new Predicate[0]));
        });
    }

    private static List<Predicate> getPredicateWithKeyword (Map<String, Object> searchKeyword, Root<LandingInfoEntity> root, CriteriaBuilder builder){

        List<Predicate> predicate = new ArrayList<>();
        try {
            for (String key : searchKeyword.keySet()) {
                if ("userNm".equals(key)) {
                    predicate.add(builder.like(root.get(key), "%" + searchKeyword.get(key) + "%"));
                } else if ("telNo".equals(key)) {
                    predicate.add(builder.like(root.get(key), "%" + searchKeyword.get(key) + "%"));
                } else if ("mutual".equals(key)) {
                    predicate.add(builder.like(root.get(key), "%" + searchKeyword.get(key) + "%"));
                } else if ("businessNo".equals(key)) {
                    predicate.add(builder.like(root.get(key), "%" + searchKeyword.get(key) + "%"));
                } if ("address".equals(key)) {
                    predicate.add(builder.like(root.get(key), "%" + searchKeyword.get(key) + "%"));
                }

                if ("visitAt".equals(key)) {
                    predicate.add(builder.between(root.get(key), searchKeyword.get(key).toString().split(",")[0], searchKeyword.get(key).toString().split(",")[1]));
                } else if ("acptAt".equals(key)) {
                    DateTimeFormatter dFmt = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    String[] dateParam = searchKeyword.get(key).toString().split(",");
                    LocalDateTime fromDate =  LocalDateTime.parse(dateParam[0], dFmt);
                    LocalDateTime toDate = LocalDateTime.parse(dateParam[1], dFmt);
                    predicate.add(builder.between(root.get(key), fromDate, toDate));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return predicate;
    }
}
