import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo

class ReportExtension extends AbstractAnnotationDrivenExtension<Report> { // <1>

    @Override
    void visitSpecAnnotation(Report annotation, SpecInfo spec) {
        spec.addListener(new AbstractRunListener() { // <2>

            @Override
            void afterFeature(FeatureInfo feature) {
                for (block in feature.blocks) { // <3>
                    for (text in block.texts) { // <4>
                        println "${block.kind.name().toLowerCase()} $text" // <5>
                    }
                }
            }
        })
    }
}
