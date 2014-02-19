package com.test.projet.jbehave;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory.ResolveToPackagedName;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;

import com.test.projet.jbehave.steps.GererLivreSteps;

public class eBiblioStoryEmbedder extends JUnitStories {

    private final CrossReference xref = new CrossReference();

    private final String STORY_LOCATION = "";//"com/test/projet/stories/**/*.story";
    
    public eBiblioStoryEmbedder() {
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(60);
        // Uncomment to set meta filter, which can also be set via Ant or Maven
        // configuredEmbedder().useMetaFilters(Arrays.asList("+theme parametrisation"));
    }

    @Override
    public Configuration configuration() {
        Keywords frKeywords = new LocalizedKeywords(Locale.FRENCH);
        Class<? extends Embeddable> embeddableClass = this.getClass();
        URL codeLocation = CodeLocations.codeLocationFromClass(embeddableClass);
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        // Start from default ParameterConverters instance
        ParameterConverters parameterConverters = new ParameterConverters();
        // factory to allow parameter conversion and loading from external
        // resources (used by StoryParser too)
        // ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(Locale.FRENCH),
        // new LoadFromClasspath(embeddableClass), parameterConverters);
        // add custom converters
        parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd"))/*
                                                                                                * , new
                                                                                                * ExamplesTableConverter
                                                                                                * (examplesTableFactory)
                                                                                                */);

        return new MostUsefulConfiguration()
                .useKeywords(frKeywords)
                .useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryParser(new RegexStoryParser(frKeywords))
                .useStoryPathResolver(new UnderscoredCamelCaseResolver())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(codeLocation)
                                .withDefaultFormats().withPathResolver(new ResolveToPackagedName())
                                .withViewResources(viewResources).withFormats(CONSOLE, TXT, HTML, XML)
                                .withFailureTrace(true).withFailureTraceCompression(true).withCrossReference(xref))
                .useParameterConverters(parameterConverters)
                // use '%' instead of '$' to identify parameters
                .useStepPatternParser(new RegexPrefixCapturingPatternParser("%")).useStepMonitor(xref.getStepMonitor());
    }


    @Override
    protected List<String> storyPaths() {
        URL searchInURL = CodeLocations.codeLocationFromClass(this.getClass());
        return new StoryFinder().findPaths(searchInURL, STORY_LOCATION, "");
    }

  
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new GererLivreSteps());
    }

}