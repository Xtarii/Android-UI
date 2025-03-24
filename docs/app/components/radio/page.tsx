import CodeBlock from "@/components/code/code";
import { Box, Typography } from "@mui/material";
import Image from "next/image";
import { ReactElement } from "react";

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Radio Group</Typography>
        <Box sx={{ display: "flex", width: "fit-content" }}>
            <Image
                src={"../components/radio/image.png"}
                alt="Image of a simple radio group"

                width={300} height={150} priority

                style={{ borderRadius: "10px",
                    margin: "auto 5%"
                }}
            />
            <Box sx={{ margin: "auto" }}>
                <CodeBlock>{
                    'RadioGroup(value = 0, options = mutableListOf(\n' +
                        '\tRadio(0, "value 1"),\n' +
                        '\tRadio(1, "Value 2")\n' +
                    '), onChange = { value -> /* The value of the selected option */ })\n'
                }</CodeBlock>
            </Box>
        </Box>
        <Box marginTop={"25px"}>
            <Typography>
                The value of the <code>RadioGroup</code> should be a <code>state</code>.
                And the value can be updated in the <code>onClick</code> callback that
                gives the value of the selected option.
            </Typography>
            <Typography>
                By providing a <code>style</code> argument to the RadioGroup further
                customization can be implemented.
                <br />
                By providing <code>vertical = false</code> the RadioGroup layout will change
                to horizontal.
            </Typography>
            <CodeBlock>{
                'style = DefaultStyles.Radio.group.copy(\n' +
                    "\tvertical = false\n" +
                ')\n'
            }</CodeBlock>
            <Typography>
                In the default styles, the component width and height is set to fit
                the inner content in vertical layout. So when using horizontal
                layout the height and width may need to be changed.
            </Typography>
        </Box>
    </div>)
}
