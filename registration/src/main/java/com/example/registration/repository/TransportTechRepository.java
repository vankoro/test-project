package com.example.registration.repository;

import com.example.registration.model.Filter;
import com.example.registration.model.TransportTechnologyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransportTechRepository {
    private EntityManager em;

    @Autowired
    public TransportTechRepository(EntityManager em) {
        this.em = em;
    }

    public List<TransportTechnologyEntity> getTransportTechnologyByFilter(Filter filter){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TransportTechnologyEntity> cq = cb.createQuery(TransportTechnologyEntity.class);

        Root<TransportTechnologyEntity> tt = cq.from(TransportTechnologyEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getIsWithTrailer() != null) {
            predicates.add(cb.equal(tt.get("is_with_trailer"), filter.getIsWithTrailer()));
        }

        if (filter.getDateOfIssue() != null) {
            predicates.add(cb.equal(tt.get("date_of_issue"), filter.getDateOfIssue()));
        }

        if (filter.getBrand() != null) {
            predicates.add(cb.equal(tt.get("brand"), filter.getBrand()));
        }

        if (filter.getModel() != null) {
            predicates.add(cb.equal(tt.get("model"), filter.getModel()));
        }

        if (filter.getNumber() != null) {
            predicates.add(cb.equal(tt.get("number"), filter.getNumber()));
        }

        if (filter.getCategory() != null) {
            predicates.add(cb.equal(tt.get("category"), filter.getCategory()));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();

    }
}
