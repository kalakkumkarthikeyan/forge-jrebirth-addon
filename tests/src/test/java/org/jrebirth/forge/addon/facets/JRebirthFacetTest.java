package org.jrebirth.forge.addon.facets;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.forge.addon.facets.FacetFactory;
import org.jboss.forge.addon.projects.Project;
import org.jboss.forge.addon.projects.ProjectFactory;
import org.jboss.forge.arquillian.AddonDependency;
import org.jboss.forge.arquillian.Dependencies;
import org.jboss.forge.arquillian.archive.ForgeArchive;
import org.jboss.forge.furnace.repositories.AddonDependencyEntry;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class JRebirthFacetTest {
    
    @Deployment
    @Dependencies({
             @AddonDependency(name = "org.jrebirth.forge.addon:jrebirth"),
             @AddonDependency(name = "org.jboss.forge.addon:maven")
    })
    public static ForgeArchive getDeployment()
    {
       return ShrinkWrap.create(ForgeArchive.class)
                .addBeansXML()
                .addAsAddonDependencies(
                         AddonDependencyEntry.create("org.jboss.forge.furnace.container:cdi"),
                         AddonDependencyEntry.create("org.jboss.forge.addon:projects"),
                         AddonDependencyEntry.create("org.jboss.forge.addon:maven")
                );
    }
    
    private Project project;

    @Inject
    ProjectFactory projectFactory;

    @Inject
    FacetFactory facetFactory;

    @Before
    public void setUp()
    {
       project = projectFactory.createTempProject();
    }

   

}
