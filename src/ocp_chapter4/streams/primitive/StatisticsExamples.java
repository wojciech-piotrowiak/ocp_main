package ocp_chapter4.streams.primitive;

import org.junit.Assert;
import org.junit.Test;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

public class StatisticsExamples {
    @Test
    public void statistics() {
        //each operation close stream, not convenient
        Assert.assertEquals(3, getDoubleStream().average().getAsDouble(), 1);
        Assert.assertEquals(1, getDoubleStream().min().getAsDouble(), 1);
        Assert.assertEquals(5, getDoubleStream().max().getAsDouble(), 1);
        Assert.assertEquals(15, getDoubleStream().sum(), 1);
    }

    @Test
    public void statisticsAtOnce() {
        DoubleSummaryStatistics doubleSummaryStatistics = getDoubleStream().summaryStatistics();
        Assert.assertEquals(3, doubleSummaryStatistics.getAverage(), 1);
        Assert.assertEquals(1, doubleSummaryStatistics.getMin(), 1);
        Assert.assertEquals(5, doubleSummaryStatistics.getMax(), 1);
        Assert.assertEquals(15, doubleSummaryStatistics.getSum(), 1);
    }

    private DoubleStream getDoubleStream() {
        return DoubleStream.of(1, 2, 3, 4, 5);
    }
}
