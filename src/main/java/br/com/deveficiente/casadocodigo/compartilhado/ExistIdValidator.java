package br.com.deveficiente.casadocodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object> {
	private String domainAttribute;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistId existId) {
        domainAttribute = existId.fieldName();
        aClass = existId.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
    	/*
    	 * Esse if existe pq aqui eu não quero testar se é null poque na BeanValidation já existe essa anotação -> @NotNull
    	 */
        if (value == null) {
            return true;
        }
        Query query = entityManager.createQuery("SELECT 1 FROM " + aClass.getName() + " WHERE " + domainAttribute + " = :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Já existe um registro " + aClass + " com o atributo"+ domainAttribute + " igual: " + value);
        return !list.isEmpty();
    }
}
