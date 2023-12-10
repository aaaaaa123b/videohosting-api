package by.harlap.demo.repository.specification;

import by.harlap.demo.dto.filter.ChannelFilterDTO;
import by.harlap.demo.model.Channel;
import by.harlap.demo.model.Channel_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ChannelSpecificationProvider {

    public Specification<Channel> buildSpecification(ChannelFilterDTO filter) {
        return (root, query, builder) -> builder.and(
                filterName(root, builder, filter.getName()),
                filterLanguage(root, builder, filter.getLanguage()),
                filterCategory(root, builder, filter.getCategory())
        );
    }

    private Predicate filterName(Root<Channel> root, CriteriaBuilder builder, String name) {
        return (name != null && !name.isBlank())
                ? builder.like(root.get(Channel_.NAME), "%" + name + "%")
                : builder.conjunction();
    }

    private Predicate filterLanguage(Root<Channel> root, CriteriaBuilder builder, String language) {
        return (language != null && !language.isBlank())
                ? builder.equal(root.get(Channel_.LANGUAGE), language)
                : builder.conjunction();
    }

    private Predicate filterCategory(Root<Channel> root, CriteriaBuilder builder, String category) {
        return (category != null && !category.isBlank())
                ? builder.equal(root.get(Channel_.CATEGORY), category)
                : builder.conjunction();
    }
}
