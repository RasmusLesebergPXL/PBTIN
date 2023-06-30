using LinqExamples.Models;

namespace LinqExamples
{
    public class SelectExamples
    {
        public IList<int> GetLengthOfWords(IEnumerable<string?> words)
        {
            var wordQuery =
                (from word in words
                 select word is null ? 0 : word.Length).ToList();

            return wordQuery;
        }

        public IList<AngleInfo> ConvertAnglesToAngleInfos(IEnumerable<double> anglesInDegrees)
        {
            var angleQuery =
                (from angle in anglesInDegrees
                 select new AngleInfo
                 {
                     Angle = angle,
                     Cosinus = Math.Cos(angle * Math.PI / 180),
                     Sinus = Math.Sin(angle * Math.PI / 180)
                 }).ToList();

            return angleQuery;
        }
    }
}