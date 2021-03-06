package org.jboss.windup.rules.apps.java.scan.provider;

import org.jboss.windup.config.AbstractRuleProvider;
import org.jboss.windup.config.metadata.MetadataBuilder;
import org.jboss.windup.config.phase.ClassifyFileTypesPhase;
import org.jboss.windup.graph.GraphContext;
import org.jboss.windup.rules.apps.java.model.JavaClassFileModel;
import org.jboss.windup.rules.apps.java.model.JavaSourceFileModel;
import org.jboss.windup.rules.files.FileMapping;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;

/**
 * Discovers .class files from the applications being analyzed.
 */
public class JavaFileMappingRuleProvider extends AbstractRuleProvider
{
    public JavaFileMappingRuleProvider()
    {
        super(MetadataBuilder.forProvider(JavaFileMappingRuleProvider.class)
                    .setPhase(ClassifyFileTypesPhase.class));
    }

    @Override
    public Configuration getConfiguration(GraphContext context)
    {
        return ConfigurationBuilder.begin()
                    .addRule(FileMapping.from(".*\\.java$").to(JavaSourceFileModel.class))
                    .addRule(FileMapping.from(".*\\.class$").to(JavaClassFileModel.class));
    }
}
